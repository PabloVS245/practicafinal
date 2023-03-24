package com.atsistemas.proyectofinal.proyectofinal.service;

import java.time.LocalDate;
import java.util.List;

import com.atsistemas.proyectofinal.proyectofinal.entity.Availabilities;
import com.atsistemas.proyectofinal.proyectofinal.entity.FiltrosAvailabilities;

public interface AvailabilitiesService {

	

	
	
	//Abrir disponibilidad: Dado un hotel, un rango de fechas y un número de habitaciones, 
	//se creará disponibilidad para dichas fechas. Si ya existe disponibilidad en alguna fecha, 
	//se sumará el número de habitaciones.
	Availabilities crearAvailabilities(Availabilities availabilities);
	
	
	
	
	//Consulta de disponibilidad: devolverá qué hoteles tienen disponibilidad dadas unas fechas 
	//de entrada y salida (fechas obligatorio), pudiendo filtrar por nombre y categoría del hotel. 
	//Para tener disponibilidad entre las fechas, tiene que haber disponible al menos una habitación 
	//para el hotel en cada día del rango.
	
	//List<Availabilities> consultaAvailabilities(LocalDate date, Integer hotel, Integer rooms);
	//List<Availabilities> consultaAvailabilities(FiltrosAvailabilities filtros);
	
	
	
	
	
	//Consultar lista de availabilities
	List<Availabilities> listarAvailabilities();








	




	
}
