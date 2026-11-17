package com.example.ClinicaOdontologica.Storage;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class SupabaseS3Service implements ArmazenamentoService {

    private final S3Client s3Client;
    private final String bucket;

    public SupabaseS3Service(
            S3Client s3Client,
            @Value("${supabase.s3.bucket}") String bucket) {
        this.s3Client = s3Client;
        this.bucket = bucket;
    }

    @Override
    public String enviarArquivo(MultipartFile arquivo) {

        if (arquivo == null || arquivo.isEmpty()) {
            throw new IllegalArgumentException("O arquivo não pode estar vazio.");
        }

        String chave = "documentos/" + UUID.randomUUID();

        String contentType = arquivo.getContentType();
        if (contentType == null || contentType.isBlank()) {
            contentType = "application/octet-stream";
        }

        try {
            s3Client.putObject(
                    PutObjectRequest.builder()
                            .bucket(bucket)
                            .key(chave)
                            .contentType(contentType)
                            .build(),
                    RequestBody.fromInputStream(
                            arquivo.getInputStream(),
                            arquivo.getSize()
                    )
            );
            return chave;

        } catch (IOException | S3Exception e) {
            throw new IllegalStateException(
                    "Erro ao enviar arquivo para o Supabase Storage.", e);
        }
    }

    @Override
    public void excluirArquivo(String chave) {

        if (chave == null || chave.isBlank()) {
            throw new IllegalArgumentException("A chave do arquivo não pode estar vazia.");
        }

        try {
            s3Client.deleteObject(
                    DeleteObjectRequest.builder()
                            .bucket(bucket)
                            .key(chave)
                            .build()
            );
        } catch (S3Exception e) {
            throw new IllegalStateException(
                    "Erro ao excluir arquivo do Supabase Storage.", e);
        }
    }
}