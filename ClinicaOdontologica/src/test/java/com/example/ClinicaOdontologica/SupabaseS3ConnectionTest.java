package com.example.ClinicaOdontologica;

import com.example.ClinicaOdontologica.service.SupabaseS3Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SupabaseS3ConnectionTest {

    @Autowired
    private SupabaseS3Service supabaseS3Service;

    @Test
    void deveConectarAoSupabaseStorage() {
        boolean conectado = supabaseS3Service.testarConexao();

        assertTrue(conectado,
                "A conexão com o Supabase Storage deveria funcionar");

        System.out.println(
                "Conexão com o Supabase Storage realizada com sucesso!"
        );
    }
}