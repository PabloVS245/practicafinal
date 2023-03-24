package com.atsistemas.proyectofinal.proyectofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.atsistemas.proyectofinal.proyectofinal.entity.Availabilities;
import com.atsistemas.proyectofinal.proyectofinal.entity.Bookings;

public interface AvailabilitiesRepository extends JpaRepository<Availabilities, Integer> , JpaSpecificationExecutor<Availabilities> {

}
