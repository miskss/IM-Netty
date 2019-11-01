package com.example.imnetty.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author peter
 * date: 2019-10-16 09:23
 **/
@Configuration
public class RedisConfig {


    //注入一个可序列object的template
    @Bean
    public  RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        Gson2JsonRedisSerializer<Object> serializer = new Gson2JsonRedisSerializer<>();
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(serializer);
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(serializer);
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }

}
