package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.Dentista;
import com.example.ClinicaOdontologica.repository.DentistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Dentista buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dentista não encontrado"));
    }
}
