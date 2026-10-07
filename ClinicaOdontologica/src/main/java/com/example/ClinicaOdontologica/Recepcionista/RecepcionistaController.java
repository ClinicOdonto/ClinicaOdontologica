package com.example.ClinicaOdontologica.Recepcionista;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public Recepcionista buscarPorId(@PathVariable UUID id) {

        return service.buscarPorId(id);
    }
}