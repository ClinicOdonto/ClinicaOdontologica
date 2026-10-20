package com.example.ClinicaOdontologica.Especialidade;

import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

class EspecialidadeServiceCacheTest {

    @Configuration
    @EnableCaching
    static class TestConfig {

        @Bean
        CacheManager cacheManager() {
            return new ConcurrentMapCacheManager("Especialidade", "EspecialidadesLista");
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
    @Test
    void deveInvalidarCacheDaListaAoCriarEspecialidade() {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(TestConfig.class)) {

            EspecialidadeRepository repository =
                    context.getBean(EspecialidadeRepository.class);

            EspecialidadeService service =
                    context.getBean(EspecialidadeService.class);

            Especialidade ortodontia = new Especialidade();
            ortodontia.setNome("Ortodontia");

            Especialidade endodontia = new Especialidade();
            endodontia.setNome("Endodontia");

            List<Especialidade> listaInicial =
                    List.of(ortodontia);

            List<Especialidade> listaAtualizada =
                    List.of(ortodontia, endodontia);

            when(repository.findAll())
                    .thenReturn(listaInicial, listaAtualizada);

            when(repository.save(endodontia))
                    .thenReturn(endodontia);

            List<Especialidade> primeira = service.listar();

            List<Especialidade> segunda = service.listar();

            assertSame(primeira, segunda);
            verify(repository, times(1)).findAll();

            service.criar(endodontia);

            verify(repository, times(1)).save(endodontia);

            List<Especialidade> terceira = service.listar();

            assertEquals(2, terceira.size());
            verify(repository, times(2)).findAll();
        }
    }
}