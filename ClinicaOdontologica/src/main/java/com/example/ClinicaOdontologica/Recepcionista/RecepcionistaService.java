package com.example.ClinicaOdontologica.Recepcionista;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecepcionistaService {

    private final RecepcionistaRepository repository;

    public RecepcionistaService(RecepcionistaRepository repository) {
        this.repository = repository;
    }

    public Recepcionista criar(Recepcionista recepcionista) {
        return repository.save(recepcionista);
    }

    public List<Recepcionista> listar() {
        return repository.findAll();
    }

    public Recepcionista buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recepcionista não encontrada"));
    }
}
