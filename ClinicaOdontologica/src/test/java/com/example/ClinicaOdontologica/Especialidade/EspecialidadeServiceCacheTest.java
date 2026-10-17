package com.example.ClinicaOdontologica.Especialidade;

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

class EspecialidadeServiceCacheTest {

    @Configuration
    @EnableCaching
    static class TestConfig {

        @Bean
        CacheManager cacheManager() {
            return new ConcurrentMapCacheManager("Especialidade");
        }

        @Bean
        EspecialidadeRepository repository() {
            return mock(EspecialidadeRepository.class);
        }

        @Bean
        EspecialidadeService especialidadeService(
                EspecialidadeRepository repository) {
            return new EspecialidadeService(repository);
        }
    }

    @Test
    void deveConsultarRepositorioApenasUmaVezParaMesmoId() {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(TestConfig.class)) {

            EspecialidadeRepository repository =
                    context.getBean(EspecialidadeRepository.class);

            EspecialidadeService service =
                    context.getBean(EspecialidadeService.class);

            UUID id = UUID.randomUUID();

            Especialidade especialidade = new Especialidade();
            especialidade.setId(id);
            especialidade.setNome("Ortodontia");

            when(repository.findById(id))
                    .thenReturn(Optional.of(especialidade));

            Especialidade primeiraConsulta = service.buscarPorId(id);
            Especialidade segundaConsulta = service.buscarPorId(id);

            assertEquals("Ortodontia", primeiraConsulta.getNome());
            assertEquals("Ortodontia", segundaConsulta.getNome());

            verify(repository, times(1)).findById(id);
        }
    }
}