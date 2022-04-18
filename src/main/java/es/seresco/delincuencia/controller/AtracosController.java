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

import es.seresco.delincuencia.controller.dto.AtracoDto;
import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.controller.dto.NewAtracoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.services.AtracosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = {"Atracos"}, description = "Manejo de atracos")
@RestController
@RequestMapping(path = "/api/atracos")
public class AtracosController {
	
	@Autowired
	private AtracosService atracoService;
	

	// Devuelve atraco por Id
	@ApiOperation(value="Obtiene un atraco según el Id")
	@GetMapping(path = "/{idAtraco}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AtracoDto> getAtraco(@PathVariable Long idAtraco) {
		AtracoDto atraco = atracoService.getAtraco(idAtraco);
		if (atraco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(atraco);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	// Devuelve todos los atracos
	@ApiOperation(value="Obtiene todos los atracos")
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AtracoDto>> getAtracos (){
		List <AtracoDto> atracos = atracoService.getAtracos();
		if (!atracos.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(atracos);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	// Devuelve los delincuentes de un atraco <- PENDIENTE!
	@ApiOperation(value="Obtiene los delincuentes de un atraco dado")
	@GetMapping(path = "/{idAtraco}/delincuentes", produces = MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity <List <DelincuenteDto>> getDelincuentesAtraco (@PathVariable Long idAtraco) throws MiValidationException{
		List <DelincuenteDto> delincuentes = atracoService.getDelincuentes(idAtraco);
		if (!delincuentes.isEmpty())
			return ResponseEntity.status(HttpStatus.OK).body(delincuentes);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}
	
	// añade un atraco pasada mediante RequestBody
	@ApiOperation(value="Añade un atraco pasado mediante RequestBody")
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <AtracoDto> createAtraco (@Validated @RequestBody NewAtracoDto newAtraco){
		AtracoDto atraco = atracoService.createAtraco(newAtraco);
		if (atraco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(atraco);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
	}
	
	
	// Actualiza un atraco indicando el id como parte del path
	@ApiOperation(value="Actualiza un atraco del que recibimos el id")
	@PutMapping(path = "/{idAtraco}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <AtracoDto> actualizaAtracoIdParam (@PathVariable Long idAtraco, @Validated @RequestBody NewAtracoDto newAtraco){
		AtracoDto atraco = atracoService.updateAtraco(idAtraco, newAtraco);
		if (atraco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(atraco);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);		
	}

	// Actualiza un atraco
	@ApiOperation(value="Actualiza un atraco del que NO recibimos el id")
	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <AtracoDto> actualizaAtraco (@Validated @RequestBody AtracoDto newAtraco) {
		AtracoDto atraco = atracoService.updateAtraco(newAtraco);
		if (atraco != null) {
			return ResponseEntity.status(HttpStatus.OK).body(atraco);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);	
	}
	
	// Elimina un atraco por id
	@ApiOperation(value="Elimina un atraco del que enviamos el id")
	@DeleteMapping(path = "/{idAtraco}")
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	public void deleteBanda(@PathVariable Long idAtraco) throws MiValidationException{
		atracoService.deleteAtraco(idAtraco);
	}
	
	
	
}
