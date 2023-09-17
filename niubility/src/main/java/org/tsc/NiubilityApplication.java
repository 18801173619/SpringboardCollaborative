package org.tsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("applicationContext.xml")
public class NiubilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(NiubilityApplication.class, args);
	}

}
