package com.atsistemas.proyectofinal.proyectofinal.mapper;

import org.springframework.stereotype.Component;
import com.atsistemas.proyectofinal.proyectofinal.dto.BookingsDto;
import com.atsistemas.proyectofinal.proyectofinal.entity.Bookings;


@Component
public class BookingsMapper {
	
	HotelMapper hotelMapper;
	
	public BookingsMapper(HotelMapper hotelMapper) {
		this.hotelMapper=hotelMapper;
	}
	
	public BookingsDto mapToDto (Bookings bookings) {
		
		return new BookingsDto(bookings.getId(), hotelMapper.mapToDto(bookings.getHotel()), bookings.getDateFrom(), bookings.getDateTo(), bookings.getEmail());
	}
	
	public Bookings mapToEntity(BookingsDto bookings) {
		return new Bookings(bookings.getId(), hotelMapper.mapToEntity(bookings.getHotel()), bookings.getDateFrom(), bookings.getDateTo(), bookings.getEmail());
	
	}
	

}
