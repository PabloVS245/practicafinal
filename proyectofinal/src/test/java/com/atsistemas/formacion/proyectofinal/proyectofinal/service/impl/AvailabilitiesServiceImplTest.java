package com.atsistemas.formacion.proyectofinal.proyectofinal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;

import com.atsistemas.proyectofinal.proyectofinal.entity.Availabilities;
import com.atsistemas.proyectofinal.proyectofinal.entity.Bookings;
import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;
import com.atsistemas.proyectofinal.proyectofinal.repository.AvailabilitiesRepository;
import com.atsistemas.proyectofinal.proyectofinal.repository.HotelRepository;
import com.atsistemas.proyectofinal.proyectofinal.serviceImpl.AvailabilitiesServiceImpl;
import com.atsistemas.proyectofinal.proyectofinal.serviceImpl.HotelServiceImpl;

@ExtendWith(MockitoExtension.class)
public class AvailabilitiesServiceImplTest {

		private AvailabilitiesServiceImpl availabilitiesServiceImpl;
		
		@Mock
		private AvailabilitiesRepository availabilitiesRepositoryMock;
		
		
		@BeforeEach
		public void setup() {
			this.availabilitiesServiceImpl = new AvailabilitiesServiceImpl(availabilitiesRepositoryMock);
		}
		
		

		@Test
		public void testCrearAvailabilities() {
		
		}
				

		@Test
		public void testListarAvailabilities() {
		}
		
		
		@Test
		public void testConsultaAvailabilities() {
			Mockito.when(availabilitiesRepositoryMock.findAll()).thenReturn(
			List.of(new Availabilities()));

			List<Availabilities> listarAvailabilities =availabilitiesServiceImpl.listarAvailabilities();

			Assertions.assertNotNull(listarAvailabilities);
			Assertions.assertTrue(listarAvailabilities.size() > 0);
			Assertions.assertEquals(1, listarAvailabilities.size());

			Mockito.verify(availabilitiesRepositoryMock).findAll();
			Mockito.verifyNoMoreInteractions(availabilitiesRepositoryMock);
			
		}
			
		@Test
		public void testListarAvailabilitiesError() {
			Mockito.when(availabilitiesRepositoryMock.findAll()).thenThrow(new DataAccessException("Error!") {
				private static final long serialVersionUID = 1L;
			});

			Assertions.assertThrows(DataAccessException.class, () -> availabilitiesServiceImpl.listarAvailabilities());

			Mockito.verify(availabilitiesRepositoryMock).findAll();
			Mockito.verifyNoMoreInteractions(availabilitiesRepositoryMock);
		}
			
}

