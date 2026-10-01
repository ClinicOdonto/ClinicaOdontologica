package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.Recepcionista;
import com.example.ClinicaOdontologica.repository.RecepcionistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Recepcionista buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recepcionista não encontrada"));
    }
}
