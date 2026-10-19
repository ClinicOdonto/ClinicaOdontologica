package com.example.ClinicaOdontologica.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;

import tools.jackson.databind.json.JsonMapper;

import com.example.ClinicaOdontologica.Categoria.CategoriaEquip;

class RedisIntegrationTest {

    @Test
    void deveArmazenarRecuperarEInvalidarCacheNoRedis() {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext()) {
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
            context.refresh();

            CacheManager cacheManager =
                    context.getBean(CacheManager.class);

            Cache cache =
                    cacheManager.getCache("TesteIntegracaoRedis");

            assertNotNull(cache);

            String chave = "teste-clinica-odonto";

            try {

                cache.put(chave, "Redis funcionando!");

                RedisConnectionFactory connectionFactory =
                        context.getBean(RedisConnectionFactory.class);

                try (var connection =
                             connectionFactory.getConnection()) {

                    byte[] chaveRedis =
                            ("TesteIntegracaoRedis::" + chave)
                                    .getBytes(StandardCharsets.UTF_8);

                    Long ttl =
                            connection.keyCommands().ttl(chaveRedis);

                    assertNotNull(ttl);

                    assertTrue(
                            ttl > 0 && ttl <= 600,
                            "O TTL deveria estar entre 1 e 600 segundos"
                    );
                }

                String resultado =
                        cache.get(chave, String.class);

                assertEquals(
                        "Redis funcionando!",
                        resultado
                );

                cache.evict(chave);

                assertNull(cache.get(chave));

            } finally {

                cache.evict(chave);
            }
        }
    }

    @Test
    void deveSerializarEDesserializarListaDeCategorias() {

        CategoriaEquip categoria = new CategoriaEquip();
        categoria.setDescricao("Categoria de teste");

        List<CategoriaEquip> categorias = List.of(categoria);

        var mapper = JsonMapper.builder().build();

        var tipoLista = mapper.getTypeFactory()
                .constructCollectionType(
                        List.class,
                        CategoriaEquip.class);

        JacksonJsonRedisSerializer<List<CategoriaEquip>> serializer =
        new JacksonJsonRedisSerializer<>(mapper, tipoLista);

        byte[] json = serializer.serialize(categorias);

        assertNotNull(json);

        List<CategoriaEquip> resultado =
                serializer.deserialize(json);

        assertNotNull(resultado);

        assertEquals(1, resultado.size());

        assertEquals(
                "Categoria de teste",
                resultado.get(0).getDescricao()
        );
    }
}