package es.seresco.delincuencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.seresco.delincuencia.controller.dto.NewSucursalDto;
import es.seresco.delincuencia.controller.dto.SucursalDto;
import es.seresco.delincuencia.controller.dto.SucursalDtoConBancoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.services.SucursalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "Sucursales" }, description = "Manejo de sucursales")
@RestController
@RequestMapping(path = "/api/sucursales")
public class SucursalesController {

	@Autowired
	private SucursalService sucursalService;

	// Devuelve sucursal por Id
	@ApiOperation(value = "Obtiene una sucursal según el Id")
	@GetMapping(path = "/{idSucursal}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SucursalDtoConBancoDto> getSucursal(@PathVariable Long idSucursal) {
		SucursalDtoConBancoDto sucursal = sucursalService.getSucursal(idSucursal);
		if (sucursal != null) {
			return ResponseEntity.status(HttpStatus.OK).body(sucursal);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Devuelve todas las sucursales
	@ApiOperation(value = "Obtiene todas las sucursales")
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SucursalDtoConBancoDto>> getSucursales() {
		List<SucursalDtoConBancoDto> sucursales = sucursalService.getSucursales();
		if (!sucursales.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(sucursales);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Añade una sucursala pasada medainte RequestBody
	@ApiOperation(value = "Añade una sucursal mediante RequestBody")
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SucursalDtoConBancoDto> createSucursal(@Validated @RequestBody NewSucursalDto newSucursal)
			throws MiValidationException {
		SucursalDtoConBancoDto sucursal = sucursalService.create(newSucursal);
		if (sucursal != null) {
			return ResponseEntity.status(HttpStatus.OK).body(sucursal);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Actualiza una sucursal indicando el id como parte del path
	@ApiOperation(value = "Actualiza una sucursal de la que recibimos el id")
	@PutMapping(path = "/{idSucursal}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SucursalDtoConBancoDto> actualizaSucursalIdParam(@PathVariable Long idSucursal,
			@Validated @RequestBody NewSucursalDto newSucursal) throws MiValidationException {
		SucursalDtoConBancoDto sucursal = sucursalService.updateSucursal(idSucursal, newSucursal);
		if (sucursal != null) {
			return ResponseEntity.status(HttpStatus.OK).body(sucursal);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Actualiza una sucursal
	@ApiOperation(value = "Actualiza una sucursal que recibimos como requestbody, sin id por el path")
	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SucursalDtoConBancoDto> actualizaSucursal(@Validated @RequestBody SucursalDto sucursalDto)
			throws MiValidationException {
		SucursalDtoConBancoDto sucursal = sucursalService.updateSucursal(sucursalDto);
		if (sucursal != null) {
			return ResponseEntity.status(HttpStatus.OK).body(sucursal);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Elimina una sucursal por id
	@ApiOperation(value = "Elimina una sucursal de la que enviamos el id por el path")
	@DeleteMapping(path = "/{idSucursal}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteSucursal(@PathVariable Long idSucursal) throws MiValidationException {
		sucursalService.deleteSucursal(idSucursal);
	}

}
