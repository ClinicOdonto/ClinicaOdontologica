package com.example.ClinicaOdontologica.Especialidade;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EspecialidadeService {

    private final EspecialidadeRepository repository;

    public EspecialidadeService(EspecialidadeRepository repository) {
        this.repository = repository;
    }

    @CacheEvict (value = "EspecialidadesLista", allEntries = true)
    public Especialidade criar(Especialidade especialidade) {
        return repository.save(especialidade);
    }

    @Cacheable(value = "EspecialidadesLista")
    public List<Especialidade> listar() {
        return repository.findAll();
    }

    @Cacheable(value = "Especialidade", key = "#id")
    public Especialidade buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Especialidade não encontrada"));
    }
}