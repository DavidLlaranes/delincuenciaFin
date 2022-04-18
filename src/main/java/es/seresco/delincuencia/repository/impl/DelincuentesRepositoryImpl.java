package es.seresco.delincuencia.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.seresco.delincuencia.controller.dto.BandaDto;
import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.repository.DelincuentesRepository;

@Repository("DelincuentesRepository")
public class DelincuentesRepositoryImpl implements DelincuentesRepository {

	
	private static List<DelincuenteDto> delincuentes = new ArrayList<DelincuenteDto>();
	
	static {
		// creamos y añadimos armas, delincuentes y los asignamos a las bandas
		BandaDto bandaPepe = new BandaDto(1001L, "La banda de Pepe", "Madrid", "Los Pepitos", 5);
		
		ArrayList<String> armasVictor = new ArrayList<>();
		armasVictor.add("Escopeta");
		armasVictor.add("Rifle");
		DelincuenteDto delincuenteVictor = new DelincuenteDto(1011L,"Víctor", armasVictor, bandaPepe);
		delincuentes.add(delincuenteVictor); 

		ArrayList<String> armasDani = new ArrayList<>();
		armasDani.add("Nunchacos");
		armasDani.add("Estrellas");
		DelincuenteDto delincuenteDani = new DelincuenteDto(1012L,"Dani", armasDani, bandaPepe);
		delincuentes.add(delincuenteDani);
	}
	

	
	@Override
	public List<DelincuenteDto> getDelincuentesByBanda(Long idBanda) {
		List <DelincuenteDto> encontrados = new ArrayList<>();
		for(DelincuenteDto delincuente : delincuentes){
			if(idBanda.equals(delincuente.getBanda().getId())) {
				encontrados.add(delincuente);
			}
		}
		return encontrados;
	}



	@Override
	public DelincuenteDto getDelincuente(Long idDelincuente) {
		for (DelincuenteDto delincuente: delincuentes) {
			if (idDelincuente.equals(delincuente.getId()))
				return delincuente;
		}
		return null;
	}



	@Override
	public List<DelincuenteDto> getDelincuentes() {
		return new ArrayList<DelincuenteDto> (delincuentes);
	}
	
}
