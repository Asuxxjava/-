package cn.wpr.common.config;

import cn.wpr.common.utils.TokenManager;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {


    @Bean
    public LettuceConnectionFactory redisConnectionFactory(RedisProperties redisProperties) {
        RedisStandaloneConfiguration redisConfiguration = new RedisStandaloneConfiguration();
        redisConfiguration.setHostName(redisProperties.getHost());
        redisConfiguration.setPort(redisProperties.getPort());
        redisConfiguration.setDatabase(redisProperties.getDatabase());
        redisConfiguration.setPassword(redisProperties.getPassword());
        return new LettuceConnectionFactory(redisConfiguration);
    }

    @Bean(name = "redisTemplate")
    @Primary
    public RedisTemplate<String, Object> jsonRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // 使用 Jackson2JsonRedisSerializer 进行序列化
        Jackson2JsonRedisSerializer<Object> serializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(objectMapper);
        // 使用 StringRedisSerializer 进行key的序列化
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //设置Key序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        //设置Value序列化方式
        redisTemplate.setValueSerializer(serializer);
        //设置Hash Key序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        //设置Hash Value序列化方式
        redisTemplate.setHashValueSerializer(serializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }




}