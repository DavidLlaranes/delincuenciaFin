package es.seresco.delincuencia.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.AtracoDto;
import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.controller.dto.NewAtracoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.repository.OLDAtracosRepository;
import es.seresco.delincuencia.services.AtracosService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Getter
@Setter
public class AtracosServiceImp implements AtracosService{
	
	@Autowired
	OLDAtracosRepository atracosRepository;

	@Override
	public AtracoDto getAtraco(Long idAtraco) {
		log.info("Recuperando atraco");
		return atracosRepository.getAtraco(idAtraco);
	}

	@Override
	public List<AtracoDto> getAtracos() {
		log.info("Recuperando lista de atracos");
		return atracosRepository.getAtracos();
	}

	@Override
	public AtracoDto updateAtraco(Long idAtraco, NewAtracoDto newAtraco) {
		log.info("Actualizando atraco con Id dado");
		return atracosRepository.updateAtraco(idAtraco, newAtraco);
	}

	@Override
	public AtracoDto updateAtraco(AtracoDto atraco) {
		log.info("Actualizando atraco SIN Id dado");
		return atracosRepository.updateAtraco(atraco);
	}

	@Override
	public void deleteAtraco(Long idAtraco) throws MiValidationException {
		log.info("Eliminando atraco");
		atracosRepository.deleteAtraco(idAtraco);
	}

	@Override
	public AtracoDto createAtraco(NewAtracoDto newAtraco) {
		log.info("Añadiendo atraco");
		return atracosRepository.createAtraco(newAtraco);
	}

	@Override
	public List<DelincuenteDto> getDelincuentes(Long idAtraco) throws MiValidationException {
		log.info("Buscando delincuentes de un atraco");
		return atracosRepository.getDelincuentes(idAtraco);
	}

}
