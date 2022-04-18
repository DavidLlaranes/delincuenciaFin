package es.seresco.delincuencia.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import es.seresco.delincuencia.controller.dto.BandaDto;
import es.seresco.delincuencia.controller.dto.NewBandaDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.repository.BandasRepository;

@Repository("BandasRepository")
public class BandasRepositoryImpl implements BandasRepository{

	private static List<BandaDto> bandas;


	static {
		// creamos listas
		bandas = new ArrayList<>();

		// creamos y añadimos bandas
		BandaDto bandaPepe = new BandaDto(1001L, "La banda de Pepe", "Madrid", "Los Pepitos", 5);
		bandas.add(bandaPepe);

		BandaDto bandaVictor = new BandaDto(1002L, "La Banda de Víctor", "Lisboa", "Los Victorianos", 3);
		bandas.add(bandaVictor);

		BandaDto bandaAdri = new BandaDto(1003L, "La Banda de Adri", "Oviedo", "Los Adrianos", 7);
		bandas.add(bandaAdri);
	}

	
	
	public BandaDto getBanda(long id) {
		for (BandaDto banda : bandas) {
			if (banda.getId().equals(id)) {
				return banda;
			}
		}
		return null;
	}

	
	
	public BandaDto create(NewBandaDto newBanda) {

		BandaDto banda = new BandaDto();
		banda.setAlias(newBanda.getAlias());
		banda.setCiudad(newBanda.getCiudad());
		banda.setNombre(newBanda.getNombre());
		banda.setNumMiembros(newBanda.getNumMiembros());

		long idBanda = 0;
		if (!bandas.isEmpty()) {
			idBanda = bandas.get(bandas.size() - 1).getId().longValue() + 1;
		}
		banda.setId(Long.valueOf(idBanda));

		bandas.add(banda);
		return banda;
	}
	
	
	
	public List<BandaDto> findBandas (String ciudad, Integer numMiembros){
		
		List<BandaDto> bandasEncontradas = new ArrayList<>();

		for (BandaDto banda : bandas) {
			if (StringUtils.isNotBlank(ciudad) || numMiembros != null) {
				if (banda.getCiudad().equals(ciudad) && banda.getNumMiembros().equals(numMiembros)) {
					bandasEncontradas.add(banda);
				}
			} else {
				bandasEncontradas.add(banda);
			}
		}

		return bandasEncontradas;
	}
	
	

	@Override
	public BandaDto update(Long idBanda, NewBandaDto updatedBanda) throws MiValidationException{
		BandaDto banda = getBanda(idBanda);
		if (banda==null)
			return null;
		bandas.remove(banda);
		banda.setAlias(updatedBanda.getAlias());
		banda.setCiudad(updatedBanda.getCiudad());
		banda.setNombre(updatedBanda.getNombre());
		banda.setNumMiembros(updatedBanda.getNumMiembros());
		bandas.add(banda);
		return banda;
	}

	
	
	@Override
	public BandaDto update(BandaDto updatedBanda) throws MiValidationException {
		BandaDto banda = getBanda(updatedBanda.getId());
		bandas.remove(banda);
		bandas.add(updatedBanda);
		return updatedBanda;
	}

	
	
	@Override
	public void deleteBanda(Long idBanda) throws MiValidationException {
		BandaDto banda = getBanda(idBanda);
		if (banda==null)
			throw new MiValidationException("201", "Banda no encontrada");
		bandas.remove(banda);		
	}
	
}
