package com.torres.salazar.infraccionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torres.salazar.infraccionservice.entity.Infraccion;



public interface InfraccionRepository extends JpaRepository<Infraccion, Integer> {

}