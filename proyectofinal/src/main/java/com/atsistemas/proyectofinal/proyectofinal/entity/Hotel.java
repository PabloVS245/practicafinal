package com.atsistemas.proyectofinal.proyectofinal.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="hotel")
public class Hotel {
	
	
	public Hotel(Integer id, String name, Integer category) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		
	}
	
	public Hotel() {
		super();
	}



	//Creamos las entidades para que JPA pueda trabajar con objetos y no con elementos las tablas 
	//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
	@Column(name = "name", length = 50)
	private String name;
	
	
	@Column(name = "category")
	private Integer category;
	
	
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getCategory() {
		return category;
	}



	public void setCategory(Integer category) {
		this.category = category;
	}



	
}

