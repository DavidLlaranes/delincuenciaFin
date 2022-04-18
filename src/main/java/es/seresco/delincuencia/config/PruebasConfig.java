package es.seresco.delincuencia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.seresco.delincuencia.services.BandasService;
import es.seresco.delincuencia.services.impl.BandasServicePoliciaNacionalImpl;

@Configuration
public class PruebasConfig {

	
	@Bean("policiaNacional")
	public BandasService policiaNacionalService() {
		return new BandasServicePoliciaNacionalImpl();	
	}
	
}
