package com.example.ClinicaOdontologica.Documento;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/documentos")
public class ControllerDocumento {

    private final ServiceDocumento serviceDocumento;

    public ControllerDocumento(ServiceDocumento serviceDocumento) {
        this.serviceDocumento = serviceDocumento;
    }

    @PostMapping("/upload")
    public ResponseEntity<Documento> uploadDocumento(
            @RequestParam UUID idPaciente,
            @RequestParam UUID idProntuario,
            @RequestParam(required = false) String dente,
            @RequestParam String tipoDocumento,
            @RequestParam(required = false) String descricao,
            @RequestParam("arquivo") MultipartFile arquivo
    ) throws IOException {

        Documento documento = serviceDocumento.salvarDocumento(
                idPaciente,
                idProntuario,
                dente,
                tipoDocumento,
                descricao,
                arquivo
        );

        return ResponseEntity.ok(documento);
    }
}