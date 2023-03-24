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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name ="bookings")
public class Bookings {
	
		
		


		//Creamos las entidades para que JPA pueda trabajar con objetos y no con elementos las tablas 
		//
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Integer id;
		
		
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "id_hotel", nullable = false)
		private Hotel hotel;
		
		
		/*
		@Column (name = "id_hotel")
		private Integer hotel;
		*/
		
		
		@Column(name = "date_from")
		private LocalDate dateFrom;
		
		
		
		@Column(name = "date_to")
		private LocalDate dateTo;
			
				
		
		
		@Column(name = "email")
		private String email;


		public Bookings(Integer id, Hotel hotel, @NotEmpty LocalDate dateFrom, @NotEmpty LocalDate dateTo,
				@NotEmpty @Email @Size(max = 100) String email) {
			super();
			this.id = id;
			this.hotel = hotel;
			this.dateFrom = dateFrom;
			this.dateTo = dateTo;
			this.email = email;
		}

		
		public Bookings() {
			super();
		}	


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public Hotel getHotel() {
			return hotel;
		}


		public void setHotel(Hotel hotel) {
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


		public void setDateTo(LocalDate dateTo) {
			this.dateTo = dateTo;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}

		
			
	}




