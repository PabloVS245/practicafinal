package com.atsistemas.proyectofinal.proyectofinal.entity;

import java.time.LocalDate;

public class FiltrosAvailabilities {
					
	
	private LocalDate date;
	private Integer id_hotel;
	private Integer rooms;
	
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Integer getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(Integer id_hotel) {
		this.id_hotel = id_hotel;
	}
	public Integer getRooms() {
		return rooms;
	}
	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}
	
}
