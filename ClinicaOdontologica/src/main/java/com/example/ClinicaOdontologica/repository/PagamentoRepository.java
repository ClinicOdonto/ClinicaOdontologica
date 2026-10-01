package com.example.ClinicaOdontologica.repository;

import com.example.ClinicaOdontologica.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}