package com.example.ClinicaOdontologica.Equipamento;

import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EquipamentoServiceCacheTest {

    @Configuration
    @EnableCaching
    static class TestConfig {

        @Bean
        CacheManager cacheManager() {
            return new ConcurrentMapCacheManager("Equipamento");
        }

        @Bean
        EquipamentoRepository repository() {
            return mock(EquipamentoRepository.class);
        }

        @Bean
        EquipamentoService equipamentoService(
                EquipamentoRepository repository) {
            return new EquipamentoService(repository);
        }
    }

    @Test
    void deveConsultarRepositorioApenasUmaVezParaMesmoId() {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(TestConfig.class)) {

            EquipamentoRepository repository =
                    context.getBean(EquipamentoRepository.class);

            EquipamentoService service =
                    context.getBean(EquipamentoService.class);

            UUID id = UUID.randomUUID();

            Equipamento equipamento = new Equipamento();
            equipamento.setId(id);
            equipamento.setNome("Autoclave");

            when(repository.findById(id))
                    .thenReturn(Optional.of(equipamento));

            Equipamento primeiraConsulta = service.buscarPorId(id);
            Equipamento segundaConsulta = service.buscarPorId(id);

            assertEquals("Autoclave", primeiraConsulta.getNome());
            assertEquals("Autoclave", segundaConsulta.getNome());

            verify(repository, times(1)).findById(id);
        }
    }
}