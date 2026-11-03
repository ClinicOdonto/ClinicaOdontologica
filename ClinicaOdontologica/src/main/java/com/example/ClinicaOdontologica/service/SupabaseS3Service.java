// DOCUMENTO ADICIONADO PARA TESTA O S3
//package com.example.ClinicaOdontologica.service;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import software.amazon.awssdk.services.s3.S3Client;
//import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
//import software.amazon.awssdk.services.s3.model.S3Exception;
//
//@Service
//public class SupabaseS3Service {
//
//    private final S3Client s3Client;
//    private final String bucket;
//
//    public SupabaseS3Service(
//            S3Client s3Client,
//            @Value("${supabase.s3.bucket}") String bucket) {
//        this.s3Client = s3Client;
//        this.bucket = bucket;
//    }
//
//    public boolean testarConexao() {
//        try {
//            s3Client.headBucket(
//                    HeadBucketRequest.builder()
//                            .bucket(bucket)
//                            .build()
//            );
//
//            return true;
//        } catch (S3Exception e) {
//            throw new IllegalStateException(
//                    "Não foi possível acessar o bucket do Supabase. "
//                            + "Código HTTP: " + e.statusCode(),
//                    e
//            );
//        }
//    }
//}
