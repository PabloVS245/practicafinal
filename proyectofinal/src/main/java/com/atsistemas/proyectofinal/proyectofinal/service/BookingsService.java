package com.atsistemas.proyectofinal.proyectofinal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import com.atsistemas.proyectofinal.proyectofinal.entity.Bookings;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;


public interface BookingsService {

	
	//Reserva de habitación: Dado un hotel, unas fechas de entrada y salida y un email, se creará una reserva
	//Crear reserva dados un hotel, fechar from/to y un email
	Bookings crearBookings(Bookings bookings);
	
	
	//Consulta de reservas dado un hotel y fechas from/to
	//Consulta de reservas hotel: Dado un hotel y unas fechas de inicio y fin, devolver las reservas realizadas.
	//Bookings findByHotelJoinFetch(Integer hotel, LocalDate dateFrom, LocalDate DateTo);
	List<Bookings> findByHotelByDateFromByDateTo(Hotel hotel, LocalDate dateFrom, LocalDate dateTo);
	
	
	//Obtener reserva por id y mostrar datos hotel
	//Obtener reserva: dado un id de reserva, devolver los datos de esta (datos del hotel incluido).
	Bookings findByHotelJoinFetch(Integer hotel);	

	//Eliminar reserva FALTA ACTUALIZAR DISPONIBILIDAD
	//Cancelar reserva: Dado un id de reserva, eliminar la misma y 
	//actualizar la disponibilidad del hotel para los días necesarios.
	void eliminarBookings(Integer id);
	
	
		
	
	//Método de ayuda para ver si consulta la lista de reservas
	//Listar Bookings. Consultar Bookings (reservas)
		List<Bookings> listarBookings();



		
}
