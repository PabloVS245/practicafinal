package com.atsistemas.formacion.proyectofinal.proyectofinal.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;

import com.atsistemas.proyectofinal.proyectofinal.entity.Bookings;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;
import com.atsistemas.proyectofinal.proyectofinal.repository.BookingsRepository;
import com.atsistemas.proyectofinal.proyectofinal.repository.HotelRepository;
import com.atsistemas.proyectofinal.proyectofinal.serviceImpl.BookingsServiceImpl;
import com.atsistemas.proyectofinal.proyectofinal.serviceImpl.HotelServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookingsServiceImplTest {

	
	private BookingsServiceImpl bookingsServiceImpl;
	
	@Mock
	private BookingsRepository bookingsRepositoryMock;
	
	
	@BeforeEach
	public void setup() {
		this.bookingsServiceImpl = new BookingsServiceImpl(bookingsRepositoryMock);
	}
	
	@Test
	public void testListarBookings() {
		
		Mockito.when(bookingsRepositoryMock.findAll()).thenReturn(
				List.of(new Bookings()));

		List<Bookings> listarBookings = bookingsServiceImpl.listarBookings();

		Assertions.assertNotNull(listarBookings);
		Assertions.assertTrue(listarBookings.size() > 0);
		Assertions.assertEquals(1, listarBookings.size());

		Mockito.verify(bookingsRepositoryMock).findAll();
		Mockito.verifyNoMoreInteractions(bookingsRepositoryMock);
	}
	
	
	@Test
	public void testCrearBookings() {
		Bookings bookings = new Bookings();
		Hotel hotel = new Hotel(1, "Test", 2);
		bookings.setId(1);
		bookings.setHotel(hotel);
		bookings.setDateFrom(LocalDate.of(2023, 04, 01));
		bookings.setDateTo(LocalDate.of(2023, 04, 03));
		bookings.setEmail("emailtest@test.com");
		Bookings bookings2 = bookingsRepositoryMock.save(bookings);
		Mockito.verify(bookingsRepositoryMock).save(Mockito.any());
		Assertions.assertNotNull(bookings2); //Falla, no sé por qué
	}
	
	@Test
	public void testFindByHotelByDateFromByDateTo() {
		
	}
	
	
	@Test
	public void testListarBookingsError() {
		Mockito.when(bookingsRepositoryMock.findAll()).thenThrow(new DataAccessException("Error!") {
			private static final long serialVersionUID = 1L;
		});

		Assertions.assertThrows(DataAccessException.class, () -> bookingsServiceImpl.listarBookings());

		Mockito.verify(bookingsRepositoryMock).findAll();
		Mockito.verifyNoMoreInteractions(bookingsRepositoryMock);
	}
	
	@Test
	public void testFindByHotelJoinFetch(){
		
	}
	
	@Test
	public void testEliminarBookings() {
		
		Bookings bookings = new Bookings();
		Hotel hotel = new Hotel(1, "Test", 2);
		bookings.setId(1);
		bookings.setHotel(hotel);
		bookings.setDateFrom(LocalDate.of(2023, 04, 01));
		bookings.setDateTo(LocalDate.of(2023, 04, 03));
		bookings.setEmail("emailtest@test.com");
		List<Bookings>  bookingsLista = new ArrayList<>();
		bookingsLista.add(0, bookings);
		bookingsRepositoryMock.delete(bookings);
		Mockito.verify(bookingsRepositoryMock).delete(bookings);
		Assertions.assertNull(bookings); //Debería estar vacío
	}
	
	
}