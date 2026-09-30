package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.entity.CategoriaEquip;
import com.example.ClinicaOdontologica.repository.CategoriaEquipRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public CategoriaEquip buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria de equipamento não encontrada"));
    }
}
