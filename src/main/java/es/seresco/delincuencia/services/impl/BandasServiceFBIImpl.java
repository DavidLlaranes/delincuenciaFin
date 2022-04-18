package es.seresco.delincuencia.services.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.BandaDto;
import es.seresco.delincuencia.controller.dto.NewBandaDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.repository.BandasRepository;
import es.seresco.delincuencia.services.BandasService;
import es.seresco.delincuencia.services.MessageSourceDelincuencia;
import lombok.extern.slf4j.Slf4j;

@Service("fbi")
@Order(1)
@Slf4j
public class BandasServiceFBIImpl implements BandasService {
	
	private static final String BEAN_NAME = "FBI";

	@Autowired
	private BandasRepository bandasRepository;	
	
	@Autowired
	private MessageSourceDelincuencia messageSource;

	
	
	@Override	
	public BandaDto getBanda(Long idBanda) {
		log.info("Usando bean {}, para obtener banda {}", BEAN_NAME, idBanda);
		return bandasRepository.getBanda(idBanda);
	}
	

	@Override
	public BandaDto create(NewBandaDto newBanda) {
		log.info("Usando bean {}, para crear banda", BEAN_NAME);
		return bandasRepository.create(newBanda);
	}
		

	@Override
	public List<BandaDto> findBandas (String ciudad, Integer numMiembros) throws MiValidationException {
		log.info("Usando bean {}, para obtener listado de bandas...", BEAN_NAME);
		if (StringUtils.isNotBlank(ciudad) && "Oviedo".equalsIgnoreCase(ciudad.trim())) {
			throw new MiValidationException("128", messageSource.getValue("key.prueba.mensajes"));
		}
		
		return bandasRepository.findBandas(ciudad, numMiembros);
	}


	@Override
	public BandaDto updateBanda(Long idBanda, NewBandaDto updatedBanda) throws MiValidationException {
		log.info("Usando bean {}, para updatear banda {}...", BEAN_NAME, idBanda);
		return bandasRepository.update(idBanda, updatedBanda);
	}


	@Override
	public BandaDto updateBanda(BandaDto updatedBanda) throws MiValidationException {
		log.info("Usando bean {}, para updatear banda...", BEAN_NAME);
		return bandasRepository.update(updatedBanda);
	}


	@Override
	public void deleteBanda(Long idBanda) throws MiValidationException{
		log.info("Usando bean {}, para eliminar banda {}...", BEAN_NAME, idBanda);
		bandasRepository.deleteBanda(idBanda);
	}
	
}
