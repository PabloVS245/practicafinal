package com.atsistemas.proyectofinal.proyectofinal.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.handler.ResponseStatusExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.atsistemas.proyectofinal.proyectofinal.dto.AvailabilitiesDto;
import com.atsistemas.proyectofinal.proyectofinal.dto.HotelDto;
import com.atsistemas.proyectofinal.proyectofinal.entity.Availabilities;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;
import com.atsistemas.proyectofinal.proyectofinal.mapper.AvailabilitiesMapper;

import com.atsistemas.proyectofinal.proyectofinal.service.AvailabilitiesService;

@RestController
@RequestMapping("availabilities")
public class AvailabilitiesController {

	//Creamos las instancias de AvailabilitiesService y de AvailabilitiesMapper
	private AvailabilitiesService availabilitiesService;
	private AvailabilitiesMapper availabilitiesMapper;
	
	
	//Inyectamos las dependencias de AvailabilitiesService y de AvailabilitiesMapper por constructor
	
	public AvailabilitiesController(AvailabilitiesService availabilitiesService, AvailabilitiesMapper availabilitiesMapper) {
		super();
		this.availabilitiesService = availabilitiesService;
		this.availabilitiesMapper = availabilitiesMapper;
	}
	
	
			//Abrir disponibilidad: Dado un hotel, un rango de fechas y un número de habitaciones, 
			//se creará disponibilidad para dichas fechas. Si ya existe disponibilidad en alguna fecha, 
			//se sumará el número de habitaciones.
			
			@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			@ResponseStatus(code = HttpStatus.CREATED)
			public ResponseEntity<AvailabilitiesDto> crearAvailabilities(@RequestBody Availabilities availabilities) {
				AvailabilitiesDto availabilitiesDto  = availabilitiesMapper.mapToDto(availabilitiesService.crearAvailabilities(availabilities));
			if ((availabilitiesDto.getId() !=null) && (availabilitiesDto.getDate() !=null) 
					&& (availabilitiesDto.getHotel() !=null) && (availabilitiesDto.getRooms() !=null)){
				return ResponseEntity.status(HttpStatus.CREATED).body(availabilitiesDto);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
			/*
			 * @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@ResponseStatus(code = HttpStatus.CREATED)
		public ResponseEntity<HotelDto> crearHotel(@RequestBody Hotel hotel) {
			HotelDto hotelDto = hotelMapper.mapToDto(hotelService.guardarHotel(hotel));
			if( (hotelDto.getId() != null) && (hotelDto.getName() != null) && (hotelDto.getCategory() != null)) {
				return ResponseEntity.status(HttpStatus.CREATED).body(hotelDto);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
			}
		}*/
			
			}
			
			
			
			//Consulta de disponibilidad: devolverá qué hoteles tienen disponibilidad dadas unas fechas 
			//de entrada y salida (fechas obligatorio), pudiendo filtrar por nombre y categoría del hotel. 
			//Para tener disponibilidad entre las fechas, tiene que haber disponible al menos una habitación 
			//para el hotel en cada día del rango.
	
			//CON SPECIFICATION
	
			//Listar availabilities
			
			@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
			public List<AvailabilitiesDto> listarAvailabilities() {
				List<Availabilities> listarAvailabilities = availabilitiesService.listarAvailabilities();
				return listarAvailabilities.stream().map(availabilitiesMapper::mapToDto).collect(Collectors.toList());
			}
			
		
}
