package com.grngenterprise.tutodiorestkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class TutodioRestKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TutodioRestKafkaApplication.class, args);
	}

}
