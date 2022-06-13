package com.sun;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Bean
	public Redisson redisson(){
		Config config  = new Config();
		config.useSingleServer().setAddress("redis://43.142.160.159:6379");
		return (Redisson) Redisson.create(config);
	}
}
