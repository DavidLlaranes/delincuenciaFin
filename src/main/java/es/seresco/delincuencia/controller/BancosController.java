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

import es.seresco.delincuencia.controller.dto.BancoDto;
import es.seresco.delincuencia.controller.dto.NewBancoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.services.BancoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "Bancos" }, description = "Manejo de atracos")
@RestController
@RequestMapping(path = "/api/bancos")
public class BancosController {

	@Autowired
	private BancoService bancoService;

	// Devuelve banco por Id
	@ApiOperation(value = "Obtiene un banco según el Id")
	@GetMapping(path = "/{idBanco}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BancoDto> getBanco(@PathVariable Long idBanco) {
		BancoDto banco = bancoService.getBanco(idBanco);
		if (banco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(banco);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Devuelve todos los bancos
	@ApiOperation(value = "Obtiene todos los bancos")
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BancoDto>> getBancos() {
		List<BancoDto> bancos = bancoService.getBancos();
		if (!bancos.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(bancos);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Añade un banco pasado mediante RequestBody
	@ApiOperation(value = "Añade un atraco pasado mediante RequestBody")
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BancoDto> createBanco(@Validated @RequestBody NewBancoDto newBanco) {
		BancoDto banco = bancoService.create(newBanco);
		if (banco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(banco);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Actualiza un banco indicando el id como parte del path
	@ApiOperation(value = "Actualiza un banco del que recibimos el id")
	@PutMapping(path = "/{idBanco}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BancoDto> actualizaBancoIdParam(@PathVariable Long idBanco,
			@Validated @RequestBody NewBancoDto newBanco) throws MiValidationException {
		BancoDto banco = bancoService.updateBanco(idBanco, newBanco);
		if (banco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(banco);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	// Actualiza un banco
		@ApiOperation(value="Actualiza un banco del que NO recibimos el id")
		@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity <BancoDto> actualizaBanco (@Validated @RequestBody BancoDto bancoDto) throws MiValidationException{
			BancoDto banco = bancoService.updateBanco(bancoDto);
			if (banco != null) { 
				return ResponseEntity.status(HttpStatus.OK).body(banco);
			 } 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		// Elimina un banco por id
		@ApiOperation(value="Elimina un banco del que enviamos el id")
		@DeleteMapping(path = "/{idBanco}")
		@ResponseStatus(HttpStatus.NO_CONTENT) 
		public void deleteBanda(@PathVariable Long idBanco){
			bancoService.deleteBanco(idBanco);
		}


}
