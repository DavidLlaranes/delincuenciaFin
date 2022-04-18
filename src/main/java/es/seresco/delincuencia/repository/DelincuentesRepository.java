package es.seresco.delincuencia.repository;

import java.util.List;

import es.seresco.delincuencia.controller.dto.DelincuenteDto;

public interface DelincuentesRepository {

	List<DelincuenteDto> getDelincuentesByBanda(Long idBanda);

	DelincuenteDto getDelincuente(Long idDelincuente);

	List<DelincuenteDto> getDelincuentes();

}
