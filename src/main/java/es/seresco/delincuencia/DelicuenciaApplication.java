package es.seresco.delincuencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="es.seresco")
public class DelicuenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DelicuenciaApplication.class, args);
	}

}
