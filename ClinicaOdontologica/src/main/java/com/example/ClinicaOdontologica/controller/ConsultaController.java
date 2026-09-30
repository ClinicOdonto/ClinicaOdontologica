package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.entity.Consulta;
import com.example.ClinicaOdontologica.service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Consulta buscarPorId(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }
}
