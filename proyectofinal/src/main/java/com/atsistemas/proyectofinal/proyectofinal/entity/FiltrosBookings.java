package com.atsistemas.proyectofinal.proyectofinal.entity;

import java.time.LocalDate;

public class FiltrosBookings {

	private Integer id_hotel;
	private LocalDate date_from;
	private LocalDate date_to;
	private String email;
	
	
	public Integer getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(Integer id_hotel) {
		this.id_hotel = id_hotel;
	}
	public LocalDate getDate_from() {
		return date_from;
	}
	public void setDate_from(LocalDate date_from) {
		this.date_from = date_from;
	}
	public LocalDate getDate_to() {
		return date_to;
	}
	public void setDate_to(LocalDate date_to) {
		this.date_to = date_to;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
