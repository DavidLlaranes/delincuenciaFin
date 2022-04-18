package es.seresco.delincuencia.services;

import java.util.List;

import es.seresco.delincuencia.controller.dto.DelincuenteDto;

public interface DelicuentesService {

	List<DelincuenteDto> getDelicuentesByBanda(Long idBanda);

	DelincuenteDto getDelicuente(Long idDelincuente);

	List<DelincuenteDto> getDelincuentes();
	
}
