package dev.ardijorganxhi.pocketscore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PocketscoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketscoreApplication.class, args);
	}

}
