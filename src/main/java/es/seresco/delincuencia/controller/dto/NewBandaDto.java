package es.seresco.delincuencia.controller.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewBandaDto {

	@NotBlank
	private String nombre;
	@NotBlank
	private String ciudad;
	@NotBlank
	private String alias;
	@NotNull @Positive
	private Integer numMiembros;
}
