package com.atsistemas.proyectofinal.proyectofinal.service;

import java.util.List;

import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;


public interface HotelService {
	
	//Listar o consultar hoteles 
	List<Hotel> listarHoteles();
	
	//Guardar o crear hotel
	Hotel guardarHotel(Hotel hotel);

	//Buscar hotel por Id
	Hotel buscarHotel(Integer id);

	//Eliminar hotel por Id
	void eliminarHotel(Integer id);

	
}
