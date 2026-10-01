package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.model.CategoriaEquip;
import com.example.ClinicaOdontologica.repository.EquipamentoRepository;
import com.example.ClinicaOdontologica.service.CategoriaEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias-equipamentos")
public class CategoriaEquipController {

   @Autowired
   CategoriaEquipService Equipeservice;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaEquip criar(@RequestBody CategoriaEquip categoriaEquip) {
        return Equipeservice.criarCategoria(categoriaEquip);
    }

    @GetMapping
    public List<CategoriaEquip> listar() {
        return Equipeservice.BuscarCategoria();
    }

    @GetMapping("/{id}")
    public CategoriaEquip buscarPorId(@PathVariable Integer id) {
        return (Equipeservice.BuscarCategoriaId(id));
    }
}
