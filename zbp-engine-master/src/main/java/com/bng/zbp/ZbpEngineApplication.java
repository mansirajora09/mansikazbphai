package com.bng.zbp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@ComponentScan(basePackages ={"com.bng"})
@Configuration
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@EnableRedisRepositories
@SpringBootApplication
public class ZbpEngineApplication {
	private static final Logger logger = LoggerFactory.getLogger(ZbpEngineApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ZbpEngineApplication.class, args);
		logger.info("Application started");
	}

}
