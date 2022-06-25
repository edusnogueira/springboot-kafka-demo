package com.eduardo.springbootkafkademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class SpringbootKafkaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaDemoApplication.class, args);
	}

}
