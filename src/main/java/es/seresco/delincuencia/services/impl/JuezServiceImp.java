package es.seresco.delincuencia.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.EstadisticasJuezDto;
import es.seresco.delincuencia.controller.dto.JuezDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.mapper.JuezMapper;
import es.seresco.delincuencia.model.Atraco;
import es.seresco.delincuencia.model.Juez;
import es.seresco.delincuencia.model.tipos.TipoCondena;
import es.seresco.delincuencia.repository.AtracoRepository;
import es.seresco.delincuencia.repository.JuezRepository;
import es.seresco.delincuencia.services.JuezService;
import lombok.extern.slf4j.Slf4j;

@Service ("JuezService")
@Slf4j
public class JuezServiceImp implements JuezService {
	
	private static final String BEAN_NAME = "JuezServiceImp";
	
	@Autowired
	private JuezRepository juezRepository;
	
	@Autowired
	private AtracoRepository atracoRepository;
	
	@Autowired
	private JuezMapper juezMapper;

	@Override
	public JuezDto getJuez(Long idJuez) throws MiValidationException {
		log.info("Buscando el Juez {} con el bean {}", idJuez, BEAN_NAME);
		try {
		Juez juez = juezRepository.getById(idJuez);
		return juezMapper.juezToJuezDto(juez);
		} catch (EntityNotFoundException enfe) {
			log.warn("No se encontró juez");
			throw new MiValidationException("404", "Juez con id "+idJuez+" no encontrado");
		}
	}

	@Override
	public EstadisticasJuezDto getEstadisticasJuez(Long idJuez) throws MiValidationException{
		log.info("Buscando estadísticas del Juez {} con el bean {}", idJuez, BEAN_NAME);	
		try {
		Juez juez = juezRepository.getById(idJuez);
		EstadisticasJuezDto estadisticas = new EstadisticasJuezDto ();
		estadisticas.setId(idJuez);
		estadisticas.setNombre(juez.getNombre());
		estadisticas.setCodigo(juez.getCodigo());
		List <Atraco> atracos = atracoRepository.findByJuezId(idJuez);
		int numLeves = 0;
		int numGraves = 0;
		int numMuyGraves = 0;
		// recorremos los atracos para hacer el desglose
		for (Atraco atraco : atracos) {
			if (atraco.getTipoCondena().equals(TipoCondena.LEVE))
				numLeves++;
			else {
				if (atraco.getTipoCondena().equals(TipoCondena.GRAVE))
					numGraves++;
				else
					numMuyGraves++;
			}
		}		
		estadisticas.setNumCondenas(atracos.size());
		estadisticas.setNumCondenasLeves(numLeves);
		estadisticas.setNumCondenasGraves(numGraves);
		estadisticas.setNumCondenasMuyGraves(numMuyGraves);
		return estadisticas;
	} catch (EntityNotFoundException enfe) {
		log.warn("No se encontró juez");
		throw new MiValidationException("404", "Juez con id "+idJuez+" no encontrado");
	}
	}

}
