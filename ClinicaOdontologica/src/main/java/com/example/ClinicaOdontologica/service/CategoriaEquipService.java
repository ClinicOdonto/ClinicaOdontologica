package com.example.ClinicaOdontologica.service;

import com.example.ClinicaOdontologica.model.CategoriaEquip;
import com.example.ClinicaOdontologica.repository.CategoriaEquipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaEquipService {

    @Autowired
    CategoriaEquipRepository repository;

    @Cacheable(value = "CategoriaEquipe", key = "#id")
    public CategoriaEquip BuscarCategoriaId(Integer id) {
        return repository.findById(id) .orElseThrow(() -> new RuntimeException("Categoria não encontrada")); }

    public List<CategoriaEquip> BuscarCategoria(){
        return repository.findAll();
    }

    public CategoriaEquipService(CategoriaEquipRepository repository) {
        this.repository = repository;
    }

    public CategoriaEquip criarCategoria(CategoriaEquip categoriaEquip) {
        return repository.save(categoriaEquip);
    }

    public List<CategoriaEquip> listarCategoria() {
        return repository.findAll();
    }


}
