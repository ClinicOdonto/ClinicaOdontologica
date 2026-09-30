package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.CategoriaEquip;
import com.example.ClinicaOdontologica.service.CategoriaEquipService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias-equipamentos")
public class CategoriaEquipController {

    private final CategoriaEquipService service;

    public CategoriaEquipController(CategoriaEquipService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaEquip criar(@RequestBody CategoriaEquip categoriaEquip) {
        return service.criar(categoriaEquip);
    }

    @GetMapping
    public List<CategoriaEquip> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public CategoriaEquip buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}
