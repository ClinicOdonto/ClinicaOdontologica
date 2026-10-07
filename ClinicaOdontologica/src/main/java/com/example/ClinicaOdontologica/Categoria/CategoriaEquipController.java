package com.example.ClinicaOdontologica.Categoria;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public CategoriaEquip buscarPorId(@PathVariable UUID id) {

        return service.buscarPorId(id);
    }
}
