package com.example.ClinicaOdontologica.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategoriaEquipService {

    @Autowired
    CategoriaEquipRepository repository;

    @CacheEvict(
        value = "CategoriasEquipamentosLista",
       key = "T(org.springframework.cache.interceptor.SimpleKey).EMPTY")

    public CategoriaEquip criar(CategoriaEquip categoriaEquip) {
        return repository.save(categoriaEquip);
    }

    @Cacheable(value = "CategoriasEquipamentosLista")
    public List<CategoriaEquip> listar() {
        return repository.findAll();
    }

    @Cacheable(value = "CategoriaEquipe", key = "#id")
    public CategoriaEquip buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Categoria de equipamento não encontrada"
                ));
    }
}