package com.example.ClinicaOdontologica.Dentista;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DentistaService {

    private final DentistaRepository repository;

    public DentistaService(DentistaRepository repository) {
        this.repository = repository;
    }

    public Dentista criar(Dentista dentista) {
        return repository.save(dentista);
    }

    public List<Dentista> listar() {
        return repository.findAll();
    }

    public Dentista buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dentista não encontrado"));
    }
}
