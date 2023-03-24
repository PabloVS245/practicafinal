package com.atsistemas.proyectofinal.proyectofinal.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.atsistemas.proyectofinal.proyectofinal.dto.HotelDto;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;
import com.atsistemas.proyectofinal.proyectofinal.error.HotelException;
import com.atsistemas.proyectofinal.proyectofinal.mapper.HotelMapper;
import com.atsistemas.proyectofinal.proyectofinal.service.HotelService;

@RestController
@RequestMapping("hotel")

public class HotelController {
	
	//Creamos las instancias de HotelService y de HotelMapper
	private HotelService hotelService;
	private HotelMapper hotelMapper;
	
	//Inyectamos las dependencias de HotelService y de HotelMapper por constructor
	public HotelController(HotelService hotelService, HotelMapper hotelMapper) {
		super();
		this.hotelService = hotelService;
		this.hotelMapper = hotelMapper;
	}
	
	//Crear o guardar 1 hotel
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(code = HttpStatus.CREATED)
		public ResponseEntity<HotelDto> crearHotel(@RequestBody Hotel hotel) {
			HotelDto hotelDto = hotelMapper.mapToDto(hotelService.guardarHotel(hotel));
			if( (hotelDto.getName() != null) && (hotelDto.getCategory() != null)) {
				return ResponseEntity.status(HttpStatus.CREATED).body(hotelDto);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
		}
		
	//Actualizar 1 hotel por id / Modificar 1 hotel por id
		@PutMapping(value = "/{idHotel}/{name}/{category}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<HotelDto> modificarHotel(@PathVariable(value = "idHotel") Integer id, @PathVariable(value = "name") String name, 
				@PathVariable(value = "category") Integer category,
				@RequestBody Hotel hotel) {
			hotel.setId(id);
			hotel.setName(name);
			hotel.setCategory(category);
			HotelDto hotelDto = hotelMapper.mapToDto(hotelService.guardarHotel(hotel));
			if( (hotelDto.getId() != null) && (hotelDto.getName() != null) && (hotelDto.getCategory() != null)) {
				return ResponseEntity.status(HttpStatus.CREATED).body(hotelDto);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
		}
	
	//Consultar Hotel por id
		@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<HotelDto> obtenerHotel(@PathVariable(value = "id") Integer id) {
			HotelDto hotelDto = hotelMapper.mapToDto(hotelService.buscarHotel(id));
			if (hotelDto.getId() != null){  //Faltaría controlar si se pone un id mayor que el nº de hoteles en BBDD
				return ResponseEntity.status(HttpStatus.OK).body(hotelDto);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(null);
			}
		}
			
	
	//Consultar hoteles
		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(code = HttpStatus.OK)
		public List<HotelDto> listarHoteles() {
			List<Hotel> listarHoteles = hotelService.listarHoteles();
			return listarHoteles.stream().map(hotelMapper::mapToDto).collect(Collectors.toList());
		}
	
	
	

	//Eliminar o borrar Hotel por id
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarHotel(@PathVariable(value = "id") Integer id) {
		hotelService.eliminarHotel(id);

	}
	
	
	
	
	
}





