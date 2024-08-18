package com.msib.msib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MsibApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsibApplication.class, args);
	}

}
