package es.seresco.delincuencia.services;

import java.util.List;

import es.seresco.delincuencia.controller.dto.AtracoDto;
import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.controller.dto.NewAtracoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;

public interface AtracosService {
	
	AtracoDto getAtraco (Long idAtraco);
	
	List <AtracoDto> getAtracos ();
	
	AtracoDto createAtraco (NewAtracoDto newAtraco);
	
	AtracoDto updateAtraco (Long idAtraco, NewAtracoDto newAtraco);
	
	AtracoDto updateAtraco (AtracoDto atraco);
	
	void deleteAtraco (Long idAtraco) throws MiValidationException;

	List<DelincuenteDto> getDelincuentes(Long idAtraco) throws MiValidationException;
}
