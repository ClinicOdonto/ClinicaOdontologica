package com.example.ClinicaOdontologica.Documento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;

public interface RepositoryDocumento extends JpaRepository<Documento, UUID> {
    List<Documento> findByIdPaciente(UUID idPaciente);
    List<Documento> findByIdProntuario(UUID idProntuario);

}