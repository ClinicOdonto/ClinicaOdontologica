package com.example.ClinicaOdontologica.controller;

import com.example.ClinicaOdontologica.service.SupabaseS3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/storage")
public class SupabaseS3Controller {

    private final SupabaseS3Service supabaseS3Service;

    public SupabaseS3Controller(SupabaseS3Service supabaseS3Service) {
        this.supabaseS3Service = supabaseS3Service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> upload(
            @RequestParam("arquivo") MultipartFile arquivo) {

        String chave = supabaseS3Service.enviarArquivo(arquivo);

        return ResponseEntity.ok(
                "Arquivo enviado com sucesso! Chave: " + chave
        );
    }
}