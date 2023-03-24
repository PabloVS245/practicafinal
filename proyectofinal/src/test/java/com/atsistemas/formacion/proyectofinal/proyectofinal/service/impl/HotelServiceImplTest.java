package com.atsistemas.formacion.proyectofinal.proyectofinal.service.impl;

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

import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;
import com.atsistemas.proyectofinal.proyectofinal.repository.HotelRepository;
import com.atsistemas.proyectofinal.proyectofinal.serviceImpl.HotelServiceImpl;


@ExtendWith(MockitoExtension.class)
public class HotelServiceImplTest {

	
	private HotelServiceImpl hotelServiceImpl;
	
	@Mock
	private HotelRepository hotelRepositoryMock;
	
	
	@BeforeEach
	public void setup() {
		this.hotelServiceImpl = new HotelServiceImpl(hotelRepositoryMock);
	}
	
	@Test
	public void testListarHoteles() {
		Mockito.when(hotelRepositoryMock.findAll()).thenReturn(
				List.of(new Hotel(1, "Test", 2), new Hotel(2, "Test", 3)));

		List<Hotel> listarHoteles = hotelServiceImpl.listarHoteles();

		Assertions.assertNotNull(listarHoteles);
		Assertions.assertTrue(listarHoteles.size() > 0);
		Assertions.assertEquals(2, listarHoteles.size());

		Mockito.verify(hotelRepositoryMock).findAll();
		Mockito.verifyNoMoreInteractions(hotelRepositoryMock);
	}
	
	@Test
	public void testListarHotelesError() {
		Mockito.when(hotelRepositoryMock.findAll()).thenThrow(new DataAccessException("Error!") {
			private static final long serialVersionUID = 1L;
		});

		Assertions.assertThrows(DataAccessException.class, () -> hotelServiceImpl.listarHoteles());

		Mockito.verify(hotelRepositoryMock).findAll();
		Mockito.verifyNoMoreInteractions(hotelRepositoryMock);
	}
	
	@Test
	public void testBuscarHotel() {
		Mockito.when(hotelRepositoryMock.findById(1))
				.thenReturn(Optional.of(new Hotel(1, "Test", 2)));

		Hotel hotel = hotelServiceImpl.buscarHotel(1);

		Assertions.assertNotNull(hotel);
		Assertions.assertEquals(1, hotel.getId());

		Mockito.verify(hotelRepositoryMock).findById(Mockito.any());
		Mockito.verifyNoMoreInteractions(hotelRepositoryMock);
	}
	
	
	@Test
	public void testGuardarHotel() {
		
		Hotel hotel = new Hotel (1, "hotel test", 3);
		Hotel hotel2 = hotelRepositoryMock.save(hotel);
		Mockito.verify(hotelRepositoryMock).save(Mockito.any());
		Assertions.assertNotNull(hotel2); //Falla, no sé por qué
	}
	
		
	
	@Test
	public void testEliminarHotel() {
		
		Hotel hotel = new Hotel (1, "hotel test", 3);
		List<Hotel>  hoteles = new ArrayList<>();
		hoteles.add(0, hotel);
		hotelRepositoryMock.delete(hotel);
		Mockito.verify(hotelRepositoryMock).delete(hotel);
		Assertions.assertNull(hoteles); //Debería estar vacío
	}
	
}


