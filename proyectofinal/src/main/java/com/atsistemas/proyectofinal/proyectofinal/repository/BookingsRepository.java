package com.atsistemas.proyectofinal.proyectofinal.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.atsistemas.proyectofinal.proyectofinal.entity.Bookings;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;


public interface BookingsRepository extends JpaRepository<Bookings, Integer> , JpaSpecificationExecutor<Bookings> {

	

	//Obtener reserva por id y mostrar datos hotel
	//Obtener reserva: dado un id de reserva, devolver los datos de esta (datos del hotel incluido).
	
	@Query("FROM Bookings b JOIN FETCH b.hotel h where b.id = ?1")
	Bookings findByHotelJoinFetch(Integer id);

	
	
	
	//Consulta de reservas dado un hotel y fechas from/to
	//Consulta de reservas hotel: Dado un hotel y unas fechas de inicio y fin, devolver las reservas realizadas.
	/*
	@Query("FROM Bookings b JOIN FETCH b.hotel h where h.id = ?1 and b.dateFrom = ?1 and b.dateTo =1?")
	Bookings findByHotelJoinFetch(Integer hotel, LocalDate dateFrom, LocalDate DateTo);
	*/
	
	
	@Query(value = "SELECT *\r\n"
			+ "	FROM bookings b \r\n"
			+ "	RIGHT JOIN hotel h \r\n"
			+ "	ON b.id_hotel  = h.id where b.date_from  = ?1 and b.date_to = ?1", nativeQuery = true)
	public List<Bookings> findByHotelByDateFromByDateTo(Hotel hotel, LocalDate dateFrom, LocalDate dateTo);
	
	
	


}
