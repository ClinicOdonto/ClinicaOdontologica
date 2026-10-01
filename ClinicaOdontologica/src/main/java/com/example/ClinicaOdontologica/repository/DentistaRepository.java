package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.model.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistaRepository extends JpaRepository<Dentista, Integer> {
}