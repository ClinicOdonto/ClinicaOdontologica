package com.example.ClinicaOdontologica.Consulta;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta criar(@RequestBody Consulta consulta) {
        return service.criar(consulta);
    }

    @GetMapping
    public List<Consulta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Consulta buscarPorId(@PathVariable UUID id) {

        return service.buscarPorId(id);
    }
}
