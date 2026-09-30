package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Recepcionista;
import com.example.ClinicaOdontologica.service.RecepcionistaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recepcionistas")
public class RecepcionistaController {

    private final RecepcionistaService service;

    public RecepcionistaController(RecepcionistaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recepcionista criar(@RequestBody Recepcionista recepcionista) {
        return service.criar(recepcionista);
    }

    @GetMapping
    public List<Recepcionista> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Recepcionista buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}