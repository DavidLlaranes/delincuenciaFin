package es.seresco.delincuencia.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.seresco.delincuencia.controller.dto.JuezDto;
import es.seresco.delincuencia.model.Juez;

@Mapper (componentModel = "spring")
public interface JuezMapper {
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "codigo", target = "codigo")
	@Mapping(source = "nombre", target = "nombre")
	public JuezDto juezToJuezDto (Juez juez);

}
