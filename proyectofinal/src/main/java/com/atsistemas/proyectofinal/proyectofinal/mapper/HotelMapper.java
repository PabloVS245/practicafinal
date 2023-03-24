package com.atsistemas.proyectofinal.proyectofinal.mapper;

import org.springframework.stereotype.Component;


import com.atsistemas.proyectofinal.proyectofinal.dto.HotelDto;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;

@Component
public class HotelMapper {

	public HotelDto mapToDto (Hotel hotel) {
		
		return new HotelDto(hotel.getId(), hotel.getName(), hotel.getCategory());
	}
	
	public Hotel mapToEntity(HotelDto hotel) {
		return new Hotel(hotel.getId(), hotel.getName(), hotel.getCategory());
	}
	
	
	
}


