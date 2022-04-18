package es.seresco.delincuencia.services;

import java.util.List;

import es.seresco.delincuencia.controller.dto.NewSucursalDto;
import es.seresco.delincuencia.controller.dto.SucursalDto;
import es.seresco.delincuencia.controller.dto.SucursalDtoConBancoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;

public interface SucursalService {

	public SucursalDtoConBancoDto getSucursal(Long idSucursal);

	public List<SucursalDtoConBancoDto> getSucursales();

	public SucursalDtoConBancoDto create(NewSucursalDto newSucursal) throws MiValidationException;

	public SucursalDtoConBancoDto updateSucursal(Long idSucursal, NewSucursalDto newSucursal) throws MiValidationException;

	public SucursalDtoConBancoDto updateSucursal(SucursalDto sucursalDto) throws MiValidationException;

	public void deleteSucursal(Long idSucursal) throws MiValidationException;

}
