package com.atsistemas.proyectofinal.proyectofinal.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.atsistemas.proyectofinal.proyectofinal.entity.Bookings;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;
import com.atsistemas.proyectofinal.proyectofinal.repository.BookingsRepository;
import com.atsistemas.proyectofinal.proyectofinal.repository.HotelRepository;
import com.atsistemas.proyectofinal.proyectofinal.service.BookingsService;

@Service
public class BookingsServiceImpl implements BookingsService{

	
	//Creamos una instancia de BookingsRepository
		private BookingsRepository bookingsRepository;
		
		//Inyectamos el Bean BookingsRepository por constructor
		public BookingsServiceImpl (BookingsRepository bookingsRepository) {
			this.bookingsRepository = bookingsRepository;
		}

		
		//Sobreescribimos los métodos de la interfaz BookingsService
		
		
		
		

		//Reserva de habitación: Dado un hotel, unas fechas de entrada y salida y un email, se creará una reserva
		//Crear reserva dados un hotel, fechar from/to y un email
		@Override
		@Transactional
		public Bookings crearBookings(Bookings bookings) {
			return bookingsRepository.save(bookings);
		}
		
		
		//Consulta de reservas dado un hotel y fechas from/to
		//Consulta de reservas hotel: Dado un hotel y unas fechas de inicio y fin, devolver las reservas realizadas.
		@Override
		public List<Bookings> findByHotelByDateFromByDateTo(Hotel hotel, LocalDate dateFrom, LocalDate dateTo) {
			return bookingsRepository.findByHotelByDateFromByDateTo(hotel, dateFrom, dateTo);
		}
		
				
		//Obtener reserva por id y mostrar datos hotel
		//Obtener reserva: dado un id de reserva, devolver los datos de esta (datos del hotel incluido).
		
		@Override
		public Bookings findByHotelJoinFetch(Integer id) {
			return bookingsRepository.findByHotelJoinFetch(id);
		}

		//Eliminar reserva FALTA ACTUALIZAR DISPONIBILIDAD
		//Cancelar reserva: Dado un id de reserva, eliminar la misma y 
		//actualizar la disponibilidad del hotel para los días necesarios.
		@Override
		@Transactional
		public void eliminarBookings(Integer id) {
			bookingsRepository.deleteById(id);
		}
		
		
		
		//Método de ayuda para ver si consulta la lista de reservas
		//Listar Bookings. Consultar Bookings (reservas)
		@Override
		public List<Bookings> listarBookings(){
			return bookingsRepository.findAll();
		}


			
		
		
		
		
		
		
}
