package com.example.ClinicaOdontologica.Categoria;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class CategoriaEquipServiceCacheTest {

    @Configuration
    @EnableCaching
    static class TestConfig {

        @Bean
        CacheManager cacheManager() {
            return new ConcurrentMapCacheManager(
                    "CategoriaEquipe",
                    "CategoriasEquipamentosLista"
            );
        }

        @Bean
        CategoriaEquipRepository repository() {
            return mock(CategoriaEquipRepository.class);
        }

        @Bean
        CategoriaEquipService categoriaEquipService(
                CategoriaEquipRepository repository) {

            CategoriaEquipService service = new CategoriaEquipService();
            service.repository = repository;

            return service;
        }
    }

    @Test
    void deveUtilizarCacheNaListagemEInvalidarAposCadastro() {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(TestConfig.class)) {

            CategoriaEquipRepository repository =
                    context.getBean(CategoriaEquipRepository.class);

            CategoriaEquipService service =
                    context.getBean(CategoriaEquipService.class);

            CategoriaEquip categoria1 = new CategoriaEquip();
            CategoriaEquip categoria2 = new CategoriaEquip();

            List<CategoriaEquip> listaInicial = List.of(categoria1);
            List<CategoriaEquip> listaAtualizada =
                    List.of(categoria1, categoria2);

            when(repository.findAll())
                    .thenReturn(listaInicial, listaAtualizada);

            when(repository.save(categoria2))
                    .thenReturn(categoria2);

            List<CategoriaEquip> primeira = service.listar();

            List<CategoriaEquip> segunda = service.listar();

            assertSame(primeira, segunda);
            verify(repository, times(1)).findAll();

            service.criar(categoria2);

            verify(repository, times(1)).save(categoria2);

            List<CategoriaEquip> terceira = service.listar();

            assertEquals(2, terceira.size());
            verify(repository, times(2)).findAll();
        }
    }
}