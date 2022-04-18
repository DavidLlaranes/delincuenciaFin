package es.seresco.delincuencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.seresco.delincuencia.controller.dto.EstadisticasJuezDto;
import es.seresco.delincuencia.controller.dto.JuezDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.services.JuezService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = { "Jueces" }, description = "Gestión de jueces")
@RestController
@RequestMapping(path = "/api/jueces")
public class JuecesController {

	@Autowired
	private JuezService juezService;

	// Devuelve Juez por Id
	@ApiOperation(value = "Obtiene un Juez según el Id")
	@GetMapping(path = "/{idJuez}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JuezDto> getJuez(@PathVariable Long idJuez) throws MiValidationException {
		JuezDto juez = juezService.getJuez(idJuez);
		if (juez != null) {
			return ResponseEntity.status(HttpStatus.OK).body(juez);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	// Devuelve estadísticas de un juez por Id
	@ApiOperation(value = "Obtiene estadísticas de un Juez según el Id")
	@GetMapping(path = "/estadisticas/{idJuez}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EstadisticasJuezDto> getEstadisticasJuez(@PathVariable Long idJuez)
			throws MiValidationException {
		EstadisticasJuezDto estadisticas = juezService.getEstadisticasJuez(idJuez);
		if (estadisticas != null) {
			return ResponseEntity.status(HttpStatus.OK).body(estadisticas);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

}
