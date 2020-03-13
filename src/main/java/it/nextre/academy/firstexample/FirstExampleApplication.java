package it.nextre.academy.firstexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstExampleApplication.class, args);
	}

	// todo aggiungere log su hdd (rolling file appender)

}
