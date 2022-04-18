package es.seresco.delincuencia.mapper;

import java.util.List;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import es.seresco.delincuencia.controller.dto.BancoDto;
import es.seresco.delincuencia.controller.dto.NewBancoDto;
import es.seresco.delincuencia.model.Banco;

@Mapper (componentModel = "spring")
public interface BancoMapper {
	
	@Mapping(source = "codigo", target = "codigo")
	@Mapping(source = "sede", target = "sede")
	@Mapping(source = "numSucursales", target= "numSucursales")
	public Banco newBancoDtoToBanco(NewBancoDto newBanco);
	
	@InheritInverseConfiguration
//	@Mapping(source = "codigo", target = "codigo") // podríamos escribirlo todo o indicarle Inherit inverso
//	@Mapping(source = "sede", target = "sede")
	public NewBancoDto bancoToNewBancoDto (Banco banco);
	
	@Mapping(source = "id", target = "id")
	@InheritConfiguration(name = "newBancoDtoToBanco")
	// @Mapping (source = "codigo", target = "codigo")
	// @Mapping (source = "sede", target = "sede")
	public Banco bancoDtoToBanco (BancoDto bancoDto);
	
	@InheritInverseConfiguration 
	// @Mapping (source = "id", target ="id")
	// @InheritConfiguration(name = "newBancoDtoToBanco")
	// @Mapping (source = "codigo", target = "codigo")
	// @Mapping (source = "sede", target = "sede")
	public BancoDto bancoToBancoDto(Banco banco);
	
	@InheritConfiguration(name="bancoToBancoDto")
	public List <BancoDto> bancoTomapBancoDtoList (List <Banco> bancos);

}
