package es.seresco.delincuencia.controller.dto;

import javax.validation.constraints.NotBlank;
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
public class SucursalDto {
	
	@JsonProperty("id")
	@NotNull
	private Long id;
	
	@JsonProperty("codigo")
	@NotBlank
	@Length(max=10)
	private String codigo;
	
	@JsonProperty("direccion")
	@NotBlank
	@Length(max=50)
	private String direccion;
	
	@JsonProperty("nombreDirector")
	@NotBlank
	@Length(max=100)
	private String nombreDirector;
	
	@JsonProperty("idBanco")
	@NotNull
	private Long idBanco;

}
