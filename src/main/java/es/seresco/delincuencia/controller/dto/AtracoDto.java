package es.seresco.delincuencia.controller.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtracoDto {
	
	@NotNull
	private Long id;
	@NotNull
	@Length (min=3, max=30) 
	private String nombreSucursal;
	@NotNull
	@Past
	private Date fecha;
	private List <DelincuenteDto> delincuentes; // puede ser null, un atraco sin delincuentes identificados aún

}
