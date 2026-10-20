package com.example.ClinicaOdontologica.Consulta;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsultaService {

    private final ConsultaRepository repository;

    public ConsultaService(ConsultaRepository repository) {
        this.repository = repository;
    }

    public Consulta criar(Consulta consulta) {
        return repository.save(consulta);
    }

    public List<Consulta> listar() {
        return repository.findAll();
    }

    public Consulta buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }
}