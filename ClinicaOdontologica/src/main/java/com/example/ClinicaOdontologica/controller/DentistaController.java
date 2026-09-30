package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Dentista;
import com.example.ClinicaOdontologica.service.DentistaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    private final DentistaService service;

    public DentistaController(DentistaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dentista criar(@RequestBody Dentista dentista) {
        return service.criar(dentista);
    }

    @GetMapping
    public List<Dentista> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Dentista buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}
