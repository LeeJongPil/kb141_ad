package org.kb141;

import org.kb141.process.ScheduledTasks;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan(value={"org.kb141.mapper"})
@EnableScheduling
public class Kb141Application {

	public static void main(String[] args) {
		SpringApplication.run(Kb141Application.class, args);
//		SpringApplication.run(ScheduledTasks.class, args);
	}
}
