package es.seresco.delincuencia.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DelincuenteDto {

	private Long id;
	private String nombre;
	private List<String> armas;
	private BandaDto banda;

}
