package com.atsistemas.proyectofinal.proyectofinal.serviceImpl;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.atsistemas.proyectofinal.proyectofinal.entity.Availabilities;
import com.atsistemas.proyectofinal.proyectofinal.entity.Bookings;
import com.atsistemas.proyectofinal.proyectofinal.entity.FiltrosAvailabilities;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;
import com.atsistemas.proyectofinal.proyectofinal.repository.AvailabilitiesRepository;
import com.atsistemas.proyectofinal.proyectofinal.service.AvailabilitiesService;
import com.atsistemas.proyectofinal.proyectofinal.service.HotelService;

@Service
public class AvailabilitiesServiceImpl implements AvailabilitiesService{

	
	//Creamos una instancia de AvailabilitiesRepository
			private AvailabilitiesRepository availabilitiesRepository;
			
		
			
			//Inyectamos el Bean BookingsRepository por constructor
			public AvailabilitiesServiceImpl (AvailabilitiesRepository availabilitiesRepository) {
				this.availabilitiesRepository = availabilitiesRepository;
			}

			

			
	//Sobreescribimos los métodos de la interfaz BookingsService
			
	
	//Abrir disponibilidad: Dado un hotel, un rango de fechas y un número de habitaciones, 
		//se creará disponibilidad para dichas fechas. Si ya existe disponibilidad en alguna fecha, 
		//se sumará el número de habitaciones.
		
			@Override
			@Transactional
			public Availabilities crearAvailabilities(Availabilities availabilities) {
				
			return availabilitiesRepository.save(availabilities);
				
			}








		




			
		
		//Consulta de disponibilidad: devolverá qué hoteles tienen disponibilidad dadas unas fechas 
		//de entrada y salida (fechas obligatorio), pudiendo filtrar por nombre y categoría del hotel. 
		//Para tener disponibilidad entre las fechas, tiene que haber disponible al menos una habitación 
		//para el hotel en cada día del rango.
			
			
			/*			
				@Override
		public List<Availabilities> consultaAvailabilities(FiltrosAvailabilities filtros) {
				
			//public List<Availabilities> consultaAvailabilities (LocalDate date, Integer hotel, Integer rooms) {
			Specification<Availabilities> spec = Specification.where(null);

			if (filtroDate != null) {
				Specification<Availabilities> dateSpec = filtroDate(date);
				spec = spec.and(dateSpec);
			}

			if (hotel != null) {
				Specification<Availabilities> hotelSpec = filtroGenero(hotel);
				spec = spec.and(hotelSpec);
			}
	
			if (rooms != null) {
				Specification<Availabilities> roomsSpec = filtroRooms(rooms);
				spec = spec.and(roomsSpec);
			}
	
			return availabilitiesRepository.findAll(spec);
			}
	
	*/		
			
			
			//Consultar lista de availabilities
			@Override
			public List<Availabilities> listarAvailabilities() {
			return availabilitiesRepository.findAll();
			}

}
