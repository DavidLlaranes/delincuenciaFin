package es.seresco.delincuencia.controller.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewBancoDto {
	
	@JsonProperty("codigo")
	@NotBlank
	String codigo;
	
	@JsonProperty("sede")
	@NotBlank
	String sede;

	@JsonProperty("numSucursales")
	int numSucursales;
}
