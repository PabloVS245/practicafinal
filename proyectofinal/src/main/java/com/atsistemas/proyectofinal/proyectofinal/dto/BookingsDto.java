package com.atsistemas.proyectofinal.proyectofinal.dto;

import java.time.LocalDate;



import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;

public class BookingsDto {
	
	private Integer id;
	private HotelDto hotel;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	private String email;
	
	
	
	public BookingsDto(Integer id, HotelDto hotel, LocalDate dateFrom, LocalDate dateTo, String email) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.email = email;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public HotelDto getHotel() {
		return hotel;
	}



	public void setHotel(HotelDto hotel) {
		this.hotel = hotel;
	}



	public LocalDate getDateFrom() {
		return dateFrom;
	}



	public void setDateFrom(LocalDate dateFrom) {
		this.dateFrom = dateFrom;
	}



	public LocalDate getDateTo() {
		return dateTo;
	}



	public void setDateFo(LocalDate dateTo) {
		this.dateTo = dateTo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
}
	
	