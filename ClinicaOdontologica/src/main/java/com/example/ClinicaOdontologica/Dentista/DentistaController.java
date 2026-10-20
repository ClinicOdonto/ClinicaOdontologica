package com.example.ClinicaOdontologica.Dentista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    DentistaService service;

    public DentistaController(DentistaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dentista criar(@RequestBody DentistaDtoCreate dentista) {
        return service.criar(dentista);
    }

    @GetMapping
    public List<Dentista> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Dentista buscarPorId(@PathVariable UUID id) {

        return service.buscarPorId(id);
    }
}
