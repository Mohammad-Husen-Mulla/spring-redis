package com.learn.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.learn.redis.entity.Student;

@Configuration
public class RedisConfiguration {
	
	@Bean
	public JedisConnectionFactory jdsConnection() {
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Student> rdsTemplate() {
		RedisTemplate<String, Student> rdsTemplate = new RedisTemplate<>();
		rdsTemplate.setConnectionFactory(jdsConnection());
		return rdsTemplate;
	}
}
