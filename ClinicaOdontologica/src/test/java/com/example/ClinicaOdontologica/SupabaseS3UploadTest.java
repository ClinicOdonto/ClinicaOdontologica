package com.example.ClinicaOdontologica;

import com.example.ClinicaOdontologica.service.SupabaseS3Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SupabaseS3UploadTest {

    @Autowired
    private SupabaseS3Service supabaseS3Service;

    @Test
    void deveEnviarArquivoParaSupabase() {

        byte[] conteudo = "Teste de upload do Object Store"
                .getBytes();

        MockMultipartFile arquivo = new MockMultipartFile(
                "arquivo",
                "teste-object-store.pdf",
                "application/pdf",
                "Teste de upload do Object Store".getBytes()
        );

        String chave = supabaseS3Service.enviarArquivo(arquivo);

        assertNotNull(chave);
        assertTrue(chave.startsWith("documentos/"));

        System.out.println("Upload realizado com sucesso!");
        System.out.println("Bucket: clinicodonto-documentos");
        System.out.println("Chave do arquivo: " + chave);
    }
}
