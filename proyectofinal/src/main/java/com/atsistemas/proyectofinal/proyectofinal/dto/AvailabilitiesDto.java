package com.atsistemas.proyectofinal.proyectofinal.dto;

import java.time.LocalDate;

public class AvailabilitiesDto {

	

	private Integer id;
	private LocalDate date;
	private HotelDto hotel;
	private Integer rooms;
	
	
	public AvailabilitiesDto(Integer id, LocalDate date, HotelDto hotel, Integer rooms) {
		super();
		this.id = id;
		this.date = date;
		this.hotel = hotel;
		this.rooms = rooms;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public HotelDto getHotel() {
		return hotel;
	}


	public void setHotel(HotelDto hotel) {
		this.hotel = hotel;
	}


	public Integer getRooms() {
		return rooms;
	}


	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}
	
	
	
	
}
