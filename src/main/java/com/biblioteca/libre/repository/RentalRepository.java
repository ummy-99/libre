package com.biblioteca.libre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.libre.model.Rental;

public interface RentalRepository extends JpaRepository<Rental, String> {
}
