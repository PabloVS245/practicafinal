package com.atsistemas.proyectofinal.proyectofinal.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name ="availabilities")
public class Availabilities {


	
	public Availabilities(Integer id, LocalDate date, Hotel hotel, Integer rooms) {
		super();
		this.id = id;
		this.date = date;
		this.hotel = hotel;
		this.rooms = rooms;
	}

	
	public Availabilities() {
		super();
	}


	//Creamos las entidades para que JPA pueda trabajar con objetos y no con elementos las tablas 
	//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name = "date")
	private LocalDate date;
	
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hotel", nullable = false)
	private Hotel hotel;
	
		
	@Column(name = "rooms")
	private Integer rooms;

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


	public Hotel getId_hotel() {
		return hotel;
	}


	public void setId_hotel(Hotel hotel) {
		this.hotel = hotel;
	}


	public Integer getRooms() {
		return rooms;
	}


	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}
	
	
}

