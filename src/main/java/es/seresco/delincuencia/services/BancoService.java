package es.seresco.delincuencia.services;

import java.util.List;

import es.seresco.delincuencia.controller.dto.BancoDto;
import es.seresco.delincuencia.controller.dto.NewBancoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;

public interface BancoService {

	public BancoDto getBanco(Long idBanco);
	
	public BancoDto create (NewBancoDto newBanco);

	public List<BancoDto> getBancos();

	public BancoDto updateBanco(Long idBanco, NewBancoDto newBanco) throws MiValidationException;

	public BancoDto updateBanco(BancoDto bancoDto) throws MiValidationException;

	public void deleteBanco(Long idBanco);
	
}
