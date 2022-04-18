package es.seresco.delincuencia.controller.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BandaDto {

	@NotNull
	private Long id;
	private String nombre;
	private String ciudad;
	private String alias;
	private Integer numMiembros;
}
