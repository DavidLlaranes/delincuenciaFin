package es.seresco.delincuencia.controller.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JuezDto {
	
	@JsonProperty("id")
	@NotNull
	private Long id;
	
	@JsonProperty("codigo")
	@NotNull
	@Length (max=10)
	private String codigo;
	
	@JsonProperty("Nombre")
	@NotNull
	@Length (max=100)
	private String nombre;

}
