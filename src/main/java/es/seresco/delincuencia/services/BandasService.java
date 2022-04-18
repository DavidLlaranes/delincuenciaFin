package es.seresco.delincuencia.services;

import java.util.List;

import es.seresco.delincuencia.controller.dto.BandaDto;
import es.seresco.delincuencia.controller.dto.NewBandaDto;
import es.seresco.delincuencia.exceptions.MiValidationException;

public interface BandasService {

	BandaDto getBanda(Long idBanda);
	
	BandaDto create(NewBandaDto newBanda);
	
	List<BandaDto> findBandas (String ciudad, Integer numMiembros) throws MiValidationException;
	
	BandaDto updateBanda(Long idBanda, NewBandaDto updatedBanda) throws MiValidationException;

	BandaDto updateBanda(BandaDto updatedBanda) throws MiValidationException;

	void deleteBanda(Long idBanda) throws MiValidationException;
	
}
