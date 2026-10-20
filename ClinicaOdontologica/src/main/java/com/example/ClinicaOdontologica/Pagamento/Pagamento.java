package com.example.ClinicaOdontologica.Pagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "pagamento")
@Getter
@Setter
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID idConsulta;

    private UUID idRecepcionista;

    private BigDecimal valor;

    private LocalDate dataPag;

    private String formaPagamento;

    private String status;

    public Pagamento() {
    }

    public Pagamento(
            UUID idConsulta,
            UUID idRecepcionista,
            BigDecimal valor,
            LocalDate dataPag,
            String formaPagamento,
            String status
    ) {
        this.idConsulta = idConsulta;
        this.idRecepcionista = idRecepcionista;
        this.valor = valor;
        this.dataPag = dataPag;
        this.formaPagamento = formaPagamento;
        this.status = status;
    }
}
