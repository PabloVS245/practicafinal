package com.atsistemas.proyectofinal.proyectofinal.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.atsistemas.proyectofinal.proyectofinal.dto.BookingsDto;
import com.atsistemas.proyectofinal.proyectofinal.dto.HotelDto;
import com.atsistemas.proyectofinal.proyectofinal.entity.Bookings;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;
import com.atsistemas.proyectofinal.proyectofinal.mapper.BookingsMapper;
import com.atsistemas.proyectofinal.proyectofinal.mapper.HotelMapper;
import com.atsistemas.proyectofinal.proyectofinal.service.BookingsService;
import com.atsistemas.proyectofinal.proyectofinal.service.HotelService;

@RestController
@RequestMapping("bookings")
public class BookingsController {
	
	//Creamos las instancias de BookingsService y de BookingsMapper
		private BookingsService bookingsService;
		private BookingsMapper bookingsMapper;
		
	//Inyectamos las dependencias de BookingsService y de bookingsMapper por constructor
		
		public BookingsController(BookingsService bookingsService, BookingsMapper bookingsMapper) {
			super();
			this.bookingsService = bookingsService;
			this.bookingsMapper = bookingsMapper;
		}
		

		//Reserva de habitación: Dado un hotel, unas fechas de entrada y salida y un email, se creará una reserva
		//Crear reserva dados un hotel, fechar from/to y un emaill
		
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(code = HttpStatus.CREATED)
		public ResponseEntity <BookingsDto> crearBookings(@RequestBody Bookings bookings) {
			BookingsDto bookingsDto= bookingsMapper.mapToDto(bookingsService.crearBookings(bookings));
			if((bookingsDto.getId() != null) && (bookingsDto.getHotel() != null) 
					&& (bookingsDto.getDateFrom() != null) && (bookingsDto.getDateTo() != null)
					&& (bookingsDto.getEmail() != null)) {
				return ResponseEntity.status(HttpStatus.CREATED).body(bookingsDto);
			}else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
		}
		
						
		//Consulta de reservas dado un hotel y fechas from/to
		//Consulta de reservas hotel: Dado un hotel y unas fechas de inicio y fin, devolver las reservas realizadas.
		
		@GetMapping(value = "/{hotel}/{dateFrom}/{dateTo}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<BookingsDto>> findById(@RequestParam(value = "hotel", required = false) Hotel hotel, 
			@RequestParam(value = "dateFrom", required = false) LocalDate dateFrom, 
			@RequestParam(value = "dateTo", required = false) LocalDate dateTo ) {
			//return bookingsMapper.mapToDto(bookingsService.findByHotelJoinFetch(hotel, dateFrom, dateTo));
			//return bookingsMapper.mapToDto(bookingsRepository.findByHotelByDateFromByDateTo(hotel, dateFrom, DateTo));
			List<BookingsDto> bookingsDto = bookingsService.findByHotelByDateFromByDateTo(hotel, dateFrom, dateTo).stream().map(bookingsMapper::mapToDto).collect(Collectors.toList());
			if((!bookingsDto.isEmpty())) {
				return ResponseEntity.status(HttpStatus.CREATED).body(bookingsDto);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
				}
			}
		
		
		
		//Obtener reserva por id y mostrar datos hotel
		//Obtener reserva: dado un id de reserva, devolver los datos de esta (datos del hotel incluido).
		
		@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <BookingsDto> findByHotelJoinFetch(@PathVariable(value = "id") Integer id) {
		BookingsDto bookingsDto = bookingsMapper.mapToDto(bookingsService.findByHotelJoinFetch(id));
		
		if((bookingsDto.getId() != null)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(bookingsDto);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
		}
		
				
		//Eliminar reserva FALTA ACTUALIZAR DISPONIBILIDAD
		//Cancelar reserva: Dado un id de reserva, eliminar la misma y 
		//actualizar la disponibilidad del hotel para los días necesarios.
				
		@DeleteMapping(value = "/{id}")
		@ResponseStatus(code = HttpStatus.NO_CONTENT)
		public void eliminarBookings(@PathVariable(value = "id") Integer id) {
			bookingsService.eliminarBookings(id);
		}	
			
						
		//Método de ayuda para ver si consulta la lista de reservas
		//Listar Bookings. Consultar Bookings (reservas)
		
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		public List<BookingsDto> listarBookings() {
			List<Bookings> listarBookings = bookingsService.listarBookings();
			return listarBookings.stream().map(bookingsMapper::mapToDto).collect(Collectors.toList());
		}
}
