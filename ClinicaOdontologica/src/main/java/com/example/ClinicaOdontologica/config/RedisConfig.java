package com.example.ClinicaOdontologica.config;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import com.example.ClinicaOdontologica.Categoria.CategoriaEquip;

import tools.jackson.databind.json.JsonMapper;

@Configuration
public class RedisConfig {

    @Bean
    public CacheManager cacheManager(
            RedisConnectionFactory connectionFactory) {

        RedisCacheConfiguration config =
                RedisCacheConfiguration.defaultCacheConfig()
                        .entryTtl(Duration.ofMinutes(10))
                        .serializeValuesWith(
                                RedisSerializationContext.SerializationPair
                                .fromSerializer(RedisSerializer.json()))
                        .disableCachingNullValues();

        var mapper = JsonMapper.builder().build();

        var tipoListaCategorias = mapper.getTypeFactory()
                .constructCollectionType(List.class, CategoriaEquip.class);

        JacksonJsonRedisSerializer<List<CategoriaEquip>> serializerCategorias =
        new JacksonJsonRedisSerializer<>(mapper, tipoListaCategorias);

        RedisCacheConfiguration configCategorias =
                config.serializeValuesWith(
                        RedisSerializationContext.SerializationPair
                                .fromSerializer(serializerCategorias)
                );

        return RedisCacheManager.builder(connectionFactory)
                .cacheDefaults(config)
                .withInitialCacheConfigurations(
                        Map.of("CategoriasEquipamentosLista", configCategorias))
                .build();
    }
}
