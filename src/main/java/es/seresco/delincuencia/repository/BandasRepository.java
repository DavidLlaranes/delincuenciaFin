package es.seresco.delincuencia.repository;

import java.util.List;

import es.seresco.delincuencia.controller.dto.BandaDto;
import es.seresco.delincuencia.controller.dto.NewBandaDto;
import es.seresco.delincuencia.exceptions.MiValidationException;


public interface BandasRepository {

	public BandaDto getBanda(long id);
	
	public BandaDto create(NewBandaDto newBanda);
	
	public List<BandaDto> findBandas (String ciudad, Integer numMiembros);

	public BandaDto update(Long idBanda, NewBandaDto updatedBanda) throws MiValidationException;

	public BandaDto update(BandaDto updatedBanda) throws MiValidationException;

	public void deleteBanda(Long idBanda) throws MiValidationException;
	
}
