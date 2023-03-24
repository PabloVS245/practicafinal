package com.atsistemas.proyectofinal.proyectofinal.repository;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;

@DataJpaTest
public class HotelRepositoryTest {

	
	@Autowired
	private HotelRepository hotelRepository;
		
	@Test
	public void testFindAll() {
		List<Hotel> hotel= hotelRepository.findAll();
		Assertions.assertEquals(true, hotel.contains(hotel));  //Sale como si estuviese vacío
	}
	
	@Test
	public void testFindAll2() {
		List<Hotel> hotel= hotelRepository.findAll();
		Assertions.assertEquals(6, hotel.size());  //Sale como si estuviese vacío
	}
}

//Es como si no se rellenasen las tablas. 
