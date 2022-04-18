package es.seresco.delincuencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.seresco.delincuencia.controller.dto.BandaDto;
import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.controller.dto.NewBandaDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.services.BandasService;
import es.seresco.delincuencia.services.DelicuentesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "Bandas" }, description = "Manejo de bandas")
@RestController
@RequestMapping(path = "/api/bandas")
public class BandasController {

	@Autowired
	@Qualifier("normal")
	private BandasService bandasService;

	@Autowired
	private DelicuentesService delincuentesService;

	// devuelve banda por Id
	@ApiOperation(value = "Obtiene una banda según el Id", notes = "Para poner una descripción más larga")
	@GetMapping(path = "/{idBanda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BandaDto> getBanda(@PathVariable Long idBanda) {
		BandaDto banda = bandasService.getBanda(idBanda);
		if (banda != null) {
			return ResponseEntity.status(HttpStatus.OK).body(banda);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// añade una banda pasada mediante RequestBody
	@ApiOperation(value = "Añade una banda pasándola or el RequestBody")
	@PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BandaDto> createBanda(@Validated @RequestBody NewBandaDto newBanda) {
		BandaDto banda = bandasService.create(newBanda);
		if (banda != null) {
			return ResponseEntity.status(HttpStatus.OK).body(banda);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}

	// Actualiza una banda indicando el id como parte del path
	@ApiOperation(value = "Actualiza una banda, pasándole el id en el path")
	@PutMapping(path = "/{idBanda}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BandaDto> actualizaBandaIdParam(@PathVariable Long idBanda,
			@Validated @RequestBody NewBandaDto updatedBanda) throws MiValidationException {
		BandaDto banda = bandasService.updateBanda(idBanda, updatedBanda);
		if (banda != null) {
			return ResponseEntity.status(HttpStatus.OK).body(banda);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Actualiza una banda NO indicando el id en el path
	@ApiOperation(value = "Actualiza una banda, NO pasándole el id mediante el path")
	@PutMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BandaDto> actualizaBanda(@Validated @RequestBody BandaDto updatedBanda)
			throws MiValidationException {
		BandaDto banda = bandasService.updateBanda(updatedBanda);
		if (banda != null) {
			return ResponseEntity.status(HttpStatus.OK).body(banda);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// devuelve los delincuentes de una banda
	@ApiOperation(value = "Devuelve los delincuentes de una banda cuyo id pasamos en el path")
	@GetMapping(path = "/{idBanda}/delincuentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DelincuenteDto>> getDelincuentesBanda(@PathVariable Long idBanda) {
		List<DelincuenteDto> delincEncontrados = delincuentesService.getDelicuentesByBanda(idBanda);
		if (delincEncontrados.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(delincEncontrados);
		}
	}

	// busca una banda filtrando por ciudad y el número de delincuentes
	@ApiOperation(value = "Busca una banda filtrando por ciudad y número de delincuentes, evitando Oviedo")
	@GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BandaDto>> getBandas(@RequestParam(required = false) String ciudad,
			@RequestParam(required = false) Integer numMiembros) throws MiValidationException {
		List<BandaDto> bandasEncontradas = bandasService.findBandas(ciudad, numMiembros);

		if (bandasEncontradas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(bandasEncontradas);
		}
	}

	@DeleteMapping(path = "/{idBanda}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBanda(@PathVariable Long idBanda) throws MiValidationException {
		bandasService.deleteBanda(idBanda);
	}

}
