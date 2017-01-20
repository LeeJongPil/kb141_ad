package org.kb141;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(value={"org.kb141.mapper"})
public class Kb141Application {

	public static void main(String[] args) {
		SpringApplication.run(Kb141Application.class, args);
	}
}
