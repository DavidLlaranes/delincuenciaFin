package es.seresco.delincuencia.repository.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import es.seresco.delincuencia.controller.dto.AtracoDto;
import es.seresco.delincuencia.controller.dto.BandaDto;
import es.seresco.delincuencia.controller.dto.DelincuenteDto;
import es.seresco.delincuencia.controller.dto.NewAtracoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.repository.OLDAtracosRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("AtracosRepository")
public class AtracosRepositoryImpl implements OLDAtracosRepository {

	private static List<AtracoDto> atracos;

	static {
		// creamos listas
		atracos = new ArrayList<>();

		// creamos y añadimos armas, delincuentes y los asignamos a las bandas
		BandaDto bandaPepe = new BandaDto(1001L, "La banda de Pepe", "Madrid", "Los Pepitos", 5);

		ArrayList<String> armasVictor = new ArrayList<>();
		armasVictor.add("Escopeta");
		armasVictor.add("Rifle");
		DelincuenteDto delincuenteVictor = new DelincuenteDto(1011L, "Víctor", armasVictor, bandaPepe);

		ArrayList<String> armasDani = new ArrayList<>();
		armasDani.add("Nunchacos");
		armasDani.add("Estrellas");
		DelincuenteDto delincuenteDani = new DelincuenteDto(1012L, "Dani", armasDani, bandaPepe);

		// creamos y añadimos atracos
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha = formatter.parse("2020-05-04");
			List<DelincuenteDto> delincuentes = new ArrayList<>();
			delincuentes.add(delincuenteDani);
			AtracoDto atraco = new AtracoDto(101L, "BBVA-Llaranes", fecha, delincuentes);
			atracos.add(atraco);

			fecha = formatter.parse("2021-06-09");
			delincuentes = new ArrayList<>();
			delincuentes.add(delincuenteVictor);
			atraco = new AtracoDto(102L, "Sabadell-Santurce", fecha, delincuentes);
			atracos.add(atraco);

			fecha = formatter.parse("2021-11-19");
			delincuentes.add(delincuenteDani);
			atraco = new AtracoDto(103L, "CajaRural - Mandin", fecha, delincuentes);
			atracos.add(atraco);
		} catch (ParseException er) {
			log.error("Error creando fecha");
		}
	}

	@Override
	public AtracoDto getAtraco(Long idAtraco) {
		for (AtracoDto atraco: atracos) {
			if (atraco.getId().equals((idAtraco)))
				return atraco;
		}
		return null;
	}

	@Override
	public List<AtracoDto> getAtracos() {
		return new ArrayList <AtracoDto> (atracos);
	}

	@Override
	public AtracoDto createAtraco(NewAtracoDto newAtraco) {
		AtracoDto atraco = new AtracoDto();
		atraco.setNombreSucursal(newAtraco.getNombreSucursal());
		atraco.setFecha(newAtraco.getFecha());
		atraco.setDelincuentes(newAtraco.getDelincuentes());
		long idAtraco = 0;
		if (!atracos.isEmpty()) {
			idAtraco = atracos.get(atracos.size()-1).getId().longValue()+1;
		}
		atraco.setId(idAtraco);
		atracos.add(atraco);
		return atraco;
	}

	@Override
	public AtracoDto updateAtraco(Long idAtraco, NewAtracoDto newAtraco) {
		AtracoDto atraco = getAtraco (idAtraco);
		if (atraco==null)
			return null;
		atracos.remove(atraco);
		atraco.setNombreSucursal(newAtraco.getNombreSucursal());
		atraco.setDelincuentes(newAtraco.getDelincuentes());
		atraco.setFecha(newAtraco.getFecha());
		atracos.add(atraco);
		return atraco;
	}

	@Override
	public AtracoDto updateAtraco(AtracoDto updatedAtraco) {
		AtracoDto atraco = getAtraco(updatedAtraco.getId());
		atracos.remove(atraco);
		atracos.add(updatedAtraco);
		return updatedAtraco;
	}

	@Override
	public void deleteAtraco(Long idAtraco) throws MiValidationException {
		AtracoDto atraco = getAtraco(idAtraco);
		if (atraco == null)
			throw new MiValidationException("301", "Atraco no encontrado");
		atracos.remove(atraco);

	}

	@Override
	public List<DelincuenteDto> getDelincuentes(Long idAtraco) throws MiValidationException {
		AtracoDto atraco = getAtraco(idAtraco);
		if (atraco == null)
			throw new MiValidationException("301", "Atraco no encontrado");
		return atraco.getDelincuentes();
	}

}
