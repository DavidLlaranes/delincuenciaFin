package es.seresco.delincuencia.controller.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstadisticasJuezDto extends JuezDto {
	
	
	@JsonProperty("Numero total condenas")
	@NotNull
	private int numCondenas;
	
	@JsonProperty("Numero condenas leves")
	@NotNull
	private int numCondenasLeves;
	
	@JsonProperty("Numero condenas graves")
	@NotNull
	private int numCondenasGraves;
	
	@JsonProperty("Numero condenas muy graves")
	@NotNull
	private int numCondenasMuyGraves;


}
