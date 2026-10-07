package com.example.ClinicaOdontologica.Categoria;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaEquipService {

    private final CategoriaEquipRepository repository;

    public CategoriaEquipService(CategoriaEquipRepository repository) {
        this.repository = repository;
    }

    public CategoriaEquip criar(CategoriaEquip categoriaEquip) {
        return repository.save(categoriaEquip);
    }

    public List<CategoriaEquip> listar() {
        return repository.findAll();
    }

    public CategoriaEquip buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria de equipamento não encontrada"));
    }
}
