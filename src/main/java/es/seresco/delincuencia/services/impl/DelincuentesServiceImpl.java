package es.seresco.delincuencia.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.repository.DelincuentesRepository;
import es.seresco.delincuencia.services.DelicuentesService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DelincuentesServiceImpl implements DelicuentesService {

	private static final String BEAN_NAME = "ORIGINAL";

	@Autowired
	private DelincuentesRepository delincuentesRepository;
	
	
	
	public List<DelincuenteDto> getDelicuentesByBanda(Long idBanda) {
		
		log.info("Usando bean {}, para obtener listado de delincuentes...", BEAN_NAME);
		return delincuentesRepository.getDelincuentesByBanda(idBanda);
	}



	@Override
	public DelincuenteDto getDelicuente(Long idDelincuente) {
		log.info("Usando bean {}, para obtener un delincuente...", BEAN_NAME);
		return delincuentesRepository.getDelincuente(idDelincuente);
	}



	@Override
	public List<DelincuenteDto> getDelincuentes() {
		log.info("Usando bean {}, para obtener lista de todos los delincuentes...", BEAN_NAME);
		return delincuentesRepository.getDelincuentes();
	}
	
}
