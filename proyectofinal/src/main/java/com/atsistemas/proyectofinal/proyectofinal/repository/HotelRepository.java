package com.atsistemas.proyectofinal.proyectofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


import com.atsistemas.proyectofinal.proyectofinal.entity.Hotel;



public interface HotelRepository extends JpaRepository<Hotel, Integer> , JpaSpecificationExecutor<Hotel>{

		
		
	
}
