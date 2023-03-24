package com.atsistemas.proyectofinal.proyectofinal.mapper;

import org.springframework.stereotype.Component;

import com.atsistemas.proyectofinal.proyectofinal.dto.AvailabilitiesDto;
import com.atsistemas.proyectofinal.proyectofinal.dto.BookingsDto;
import com.atsistemas.proyectofinal.proyectofinal.entity.Availabilities;
import com.atsistemas.proyectofinal.proyectofinal.entity.Bookings;
@Component
public class AvailabilitiesMapper {

		HotelMapper hotelMapper;
	
		public AvailabilitiesMapper(HotelMapper hotelMapper) {
			this.hotelMapper = hotelMapper;
		}
		
		
		
		public AvailabilitiesDto mapToDto (Availabilities availabilities) {
			
			return new AvailabilitiesDto(availabilities.getId(), availabilities.getDate() , hotelMapper.mapToDto(availabilities.getId_hotel()), availabilities.getRooms());
		}
		
			
		
		
		public Availabilities mapToEntity(AvailabilitiesDto availabilities) {
			return new Availabilities(availabilities.getId(), availabilities.getDate(), hotelMapper.mapToEntity(availabilities.getHotel()), availabilities.getRooms());
		
		}
	
}
