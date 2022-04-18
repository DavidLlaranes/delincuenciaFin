package es.seresco.delincuencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.services.DelicuentesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "Delincuentes" })
@RestController
@RequestMapping(path = "/api/delincuentes")
public class DelincuentesController {

	@Autowired
	private DelicuentesService delincuentesService;

	@ApiOperation(value = "Obtiene una lista de delincuentes para una banda", tags = { "Bandas" })
	@GetMapping(path = "/banda/{idBanda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DelincuenteDto>> getDelincuentesByBanda(Long idBanda) {
		List<DelincuenteDto> delincuentes = delincuentesService.getDelicuentesByBanda(idBanda);
		if (delincuentes != null) {
			return ResponseEntity.status(HttpStatus.OK).body(delincuentes);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@ApiOperation(value = "Obtiene un delincuente pasándole su id en el paht")
	@GetMapping(path = "/{idDelincuente}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<DelincuenteDto> getDelincuente(@PathVariable Long idDelincuente) {

		DelincuenteDto delincuente = delincuentesService.getDelicuente(idDelincuente);
		if (delincuente != null) {
			return ResponseEntity.status(HttpStatus.OK).body(delincuente);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	@ApiOperation(value = "Obtiene una lista de todos los delincuentes")
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DelincuenteDto>> getListaDelincuentes() {

		List<DelincuenteDto> delincuentes = delincuentesService.getDelincuentes();

		if (delincuentes != null) {
			return ResponseEntity.status(HttpStatus.OK).body(delincuentes);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
