package es.seresco.delincuencia.repository;

import java.util.List;

import es.seresco.delincuencia.controller.dto.AtracoDto;
import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.controller.dto.NewAtracoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;

public interface OLDAtracosRepository {

	public AtracoDto getAtraco (Long idAtraco);
	
	public List <AtracoDto> getAtracos ();
	
	public AtracoDto createAtraco (NewAtracoDto newAtraco);	
	
	public AtracoDto updateAtraco (Long idAtraco, NewAtracoDto newAtraco);
	
	public AtracoDto updateAtraco (AtracoDto atraco);
	
	public void deleteAtraco (Long idAtraco) throws MiValidationException;

	public List<DelincuenteDto> getDelincuentes(Long idAtraco) throws MiValidationException;
}
