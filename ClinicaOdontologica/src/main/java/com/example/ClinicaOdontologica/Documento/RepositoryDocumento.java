package com.example.ClinicaOdontologica.Documento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RepositoryDocumento extends JpaRepository<Documento, UUID> {
}