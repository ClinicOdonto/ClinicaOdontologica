package com.example.ClinicaOdontologica.config;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import com.example.ClinicaOdontologica.Categoria.CategoriaEquip;
import com.example.ClinicaOdontologica.Categoria.CategoriaEquipRepository;
import com.example.ClinicaOdontologica.Categoria.CategoriaEquipService;

class CategoriaRedisIntegrationTest {

    @Test
    void deveUsarCacheAutomaticoEInvalidarAoCriarCategoria() {

        CategoriaEquipRepository repository =
                mock(CategoriaEquipRepository.class);

        CategoriaEquip categoria = new CategoriaEquip();
        categoria.setDescricao("Categoria de teste");

        when(repository.findAll())
                .thenReturn(List.of(categoria));

        when(repository.save(any(CategoriaEquip.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        try (AnnotationConfigApplicationContext context =
                     criarContexto(repository)) {

            CacheManager cacheManager =
                    context.getBean(CacheManager.class);

            Cache cache =
                    cacheManager.getCache("CategoriasEquipamentosLista");

            assertNotNull(cache);

            cache.clear();

            try {
                CategoriaEquipService service =
                        context.getBean(CategoriaEquipService.class);

                assertTrue(
        org.springframework.aop.support.AopUtils.isAopProxy(service),
        "O serviço não está utilizando o proxy do Spring"
);
                assertNull(cache.get(SimpleKey.EMPTY));

                service.listar();

                verify(repository, times(1)).findAll();

                Cache.ValueWrapper valor = cache.get(SimpleKey.EMPTY);

                assertNotNull(valor);

                service.listar();

                verify(repository, times(1)).findAll();

                service.criar(new CategoriaEquip());

                verify(repository, times(1))
                        .save(any(CategoriaEquip.class));

                assertNull(cache.get(SimpleKey.EMPTY));

                service.listar();

                verify(repository, times(2)).findAll();

            } finally {
                cache.clear();
            }
        }
    }

    @Test
    void naoDeveInvalidarCacheQuandoCriacaoFalhar() {

        CategoriaEquipRepository repository =
                mock(CategoriaEquipRepository.class);

        CategoriaEquip categoria = new CategoriaEquip();
        categoria.setDescricao("Categoria de teste");

        when(repository.findAll())
                .thenReturn(List.of(categoria));

        when(repository.save(any(CategoriaEquip.class)))
                .thenThrow(new RuntimeException("Erro ao salvar categoria"));

        try (AnnotationConfigApplicationContext context =
                     criarContexto(repository)) {

            Cache cache = context.getBean(CacheManager.class)
                    .getCache("CategoriasEquipamentosLista");

            assertNotNull(cache);

            cache.clear();

            try {
                CategoriaEquipService service =
                        context.getBean(CategoriaEquipService.class);

                service.listar();

                assertNotNull(cache.get(SimpleKey.EMPTY));

                assertThrows(
                        RuntimeException.class,
                        () -> service.criar(new CategoriaEquip()));

                assertNotNull(cache.get(SimpleKey.EMPTY));

                service.listar();

                verify(repository, times(1)).findAll();

            } finally {
                cache.clear();
            }
        }
    }

    private AnnotationConfigApplicationContext criarContexto(
            CategoriaEquipRepository repository) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();

        context.registerBean(
        LettuceConnectionFactory.class,
        () -> {
            RedisStandaloneConfiguration redisConfig =
                    new RedisStandaloneConfiguration("localhost", 6379);

            redisConfig.setDatabase(1);

            return new LettuceConnectionFactory(redisConfig);
        }
);

        context.register(RedisConfig.class);
        context.register(CachingTestConfig.class);

        context.registerBean(
                CategoriaEquipRepository.class,
                () -> repository
        );

        context.register(CategoriaEquipService.class);

        context.refresh();

        return context;
    }

    @Configuration
    @EnableCaching
    static class CachingTestConfig {
    }
}