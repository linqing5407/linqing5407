package com.example.config;

import com.example.common.LocalDateTimeUtils;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: Ningbo.Chen
 * @version: v1.0
 * @copyright: TECHNOLOGY CO., LTD. (c)2015-2025
 * @createTime: 2019/3/21
 **/
@Configuration
@ConditionalOnClass(RedisOperations.class)
@EnableConfigurationProperties(RedisProperties.class)
public class RedisConfig {

    /**
     * jackson εΊεε
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(getObjectMapper());
        // valueεΌηεΊεειη¨jackson2JsonRedisSerializer
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        // keyηεΊεειη¨StringRedisSerializer
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * ε?δΉLocateDateοΌ LocateDateTimeοΌ LocalTimeεΊεε¨
     * @return
     */
    private ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        JavaTimeModule javaTimeModule = new JavaTimeModule();
        javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.DATE_TIME_FORMATTER)));
        javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.DATE_FORMATTER)));
        javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.TIME_FORMATTER)));
        javaTimeModule.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.DATE_TIME_FORMATTER)));
        javaTimeModule.addDeserializer(LocalDate.class, new LocalDateDeserializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.DATE_FORMATTER)));
        javaTimeModule.addDeserializer(LocalTime.class, new LocalTimeDeserializer(
                DateTimeFormatter.ofPattern(LocalDateTimeUtils.TIME_FORMATTER)));
        mapper.registerModule(javaTimeModule);
        //δ½Ώη¨ defaultTyping ε?η°ιη¨ηεΊεεεεεΊεε
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        return mapper;
    }

//    /**
//     * fastjson εΊεε
//     *
//     * @param redisConnectionFactory
//     * @return
//     */
//    @Bean(name = "jsonRedisTemplate")
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//
//        //δ½Ώη¨fastjsonεΊεε
//        FastJsonRedisSerializer<Object> fastJsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
//        // valueεΌηεΊεειη¨fastJsonRedisSerializer
//        template.setValueSerializer(fastJsonRedisSerializer);
//        template.setHashValueSerializer(fastJsonRedisSerializer);
//        // keyηεΊεειη¨StringRedisSerializer
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }
//
//    @Bean(name = "stringRedisTemplate")
//    @ConditionalOnMissingBean(StringRedisTemplate.class)
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        StringRedisTemplate template = new StringRedisTemplate();
//        template.setConnectionFactory(redisConnectionFactory);
//        return template;
//    }

}
