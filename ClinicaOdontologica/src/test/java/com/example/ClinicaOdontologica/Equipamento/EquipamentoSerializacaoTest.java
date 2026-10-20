package com.example.ClinicaOdontologica.Equipamento;

import org.junit.jupiter.api.Test;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class EquipamentoSerializacaoTest {

    @Test
    void deveSerializarEDesserializarEquipamento() {

        RedisSerializer<Object> serializer = RedisSerializer.json();

        Equipamento equipamento = new Equipamento();

        UUID id = UUID.randomUUID();
        UUID idCategoria = UUID.randomUUID();

        equipamento.setId(id);
        equipamento.setNome("Autoclave");
        equipamento.setMarca("Cristofoli");
        equipamento.setValidade(LocalDate.of(2028, 12, 31));
        equipamento.setCusto(new BigDecimal("2500.00"));
        equipamento.setIdCategoria(idCategoria);

        byte[] dados = serializer.serialize(equipamento);

        assertNotNull(dados);

        Object resultado = serializer.deserialize(dados);

        assertInstanceOf(Equipamento.class, resultado);

        Equipamento recuperado = (Equipamento) resultado;

        assertEquals(id, recuperado.getId());
        assertEquals("Autoclave", recuperado.getNome());
        assertEquals("Cristofoli", recuperado.getMarca());
        assertEquals(LocalDate.of(2028, 12, 31), recuperado.getValidade());
        assertEquals(0, new BigDecimal("2500.00")
                .compareTo(recuperado.getCusto()));
        assertEquals(idCategoria, recuperado.getIdCategoria());
    }
}