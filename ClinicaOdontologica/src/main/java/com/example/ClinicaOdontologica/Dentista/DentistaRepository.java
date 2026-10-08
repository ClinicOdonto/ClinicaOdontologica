package com.example.ClinicaOdontologica.Dentista;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DentistaRepository extends JpaRepository<Dentista, UUID> {
}