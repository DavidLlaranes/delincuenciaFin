package es.seresco.delincuencia.services;

import es.seresco.delincuencia.controller.dto.EstadisticasJuezDto;
import es.seresco.delincuencia.controller.dto.JuezDto;
import es.seresco.delincuencia.exceptions.MiValidationException;

public interface JuezService {
	
	public JuezDto getJuez (Long idJuez) throws MiValidationException;

	public EstadisticasJuezDto getEstadisticasJuez(Long idJuez) throws MiValidationException;
}
