package es.seresco.delincuencia.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.seresco.delincuencia.controller.dto.NewSucursalDto;
import es.seresco.delincuencia.controller.dto.SucursalDto;
import es.seresco.delincuencia.controller.dto.SucursalDtoConBancoDto;
import es.seresco.delincuencia.model.Sucursal;

@Mapper (componentModel = "spring")
public interface SucursalMapper {

	@Mapping(source = "codigo", target = "codigo")
	@Mapping(source = "direccion", target = "direccion")
	@Mapping(source = "nombreDirector", target = "nombreDirector")
	@Mapping(source = "idBanco", target = "banco.id")
	public Sucursal newSucursalDtoToSucursal (NewSucursalDto newSucursal);
	
	@InheritInverseConfiguration
	public NewSucursalDto sucursalToNewSucursalDto (Sucursal sucursal);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "codigo", target = "codigo")
	@Mapping(source = "direccion", target = "direccion")
	@Mapping(source = "nombreDirector", target = "nombreDirector")
	@Mapping(source = "idBanco", target = "banco.id")
	public Sucursal sucursalDtoToSucursal (SucursalDto sucursalDto);
	
	@InheritInverseConfiguration
	public SucursalDto sucursalToSucursalDto (Sucursal sucursal);
	
	@InheritConfiguration(name="sucursalToSucursalDto")
	public List <SucursalDto> sucursalListToSucursalDtoList (List <Sucursal> sucursales);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "codigo", target = "codigo")
	@Mapping(source = "direccion", target = "direccion")
	@Mapping(source = "nombreDirector", target = "nombreDirector")
	@Mapping(source = "banco", target = "bancoDto")
	public SucursalDtoConBancoDto sucursalToSucursalDtoConBancoDto (Sucursal sucursal);
	
	@InheritConfiguration(name="sucursalToSucursalDtoConBancoDto")
	public List <SucursalDtoConBancoDto> sucursalListToSucursalDtoConBancoDtoList (List <Sucursal> sucursales);
		
}
