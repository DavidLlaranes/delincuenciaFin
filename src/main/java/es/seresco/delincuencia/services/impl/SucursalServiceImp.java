package es.seresco.delincuencia.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.NewSucursalDto;
import es.seresco.delincuencia.controller.dto.SucursalDto;
import es.seresco.delincuencia.controller.dto.SucursalDtoConBancoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.mapper.BancoMapper;
import es.seresco.delincuencia.mapper.SucursalMapper;
import es.seresco.delincuencia.model.Banco;
import es.seresco.delincuencia.model.Sucursal;
import es.seresco.delincuencia.repository.SucursalRepository;
import es.seresco.delincuencia.services.BancoService;
import es.seresco.delincuencia.services.SucursalService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@PropertySource("classpath:application.properties")
public class SucursalServiceImp implements SucursalService {

	private static final String BEAN_NAME = "SucursalServiceImpl";

	@Autowired
	private BancoService bancoService;

	@Autowired
	private SucursalRepository sucursalRepository;

	@Autowired
	private SucursalMapper sucursalMapper;

	@Autowired
	private BancoMapper bancoMapper;
	
	@Value("${sucursal.max}")
	private int maxSucursales;

	@Override
	public SucursalDtoConBancoDto getSucursal(Long idSucursal) {
		log.info("Buscando la sucursal {} con el bean {}", idSucursal, BEAN_NAME);
		Sucursal sucursal = sucursalRepository.getById(idSucursal);
		return sucursalMapper.sucursalToSucursalDtoConBancoDto(sucursal);
	}

	@Override
	public List<SucursalDtoConBancoDto> getSucursales() {
		log.info("Buscando lisgado con todas las sucursales con el bean {}", BEAN_NAME);
		List<Sucursal> sucursales = sucursalRepository.findAll();
		return sucursalMapper.sucursalListToSucursalDtoConBancoDtoList(sucursales);
	}

	@Override
	public SucursalDtoConBancoDto create(NewSucursalDto newSucursal) throws MiValidationException {
		log.info("Creando una sucursal con el bean {}", BEAN_NAME);
		Sucursal sucursal = sucursalMapper.newSucursalDtoToSucursal(newSucursal);
		Banco banco = bancoMapper.bancoDtoToBanco(bancoService.getBanco(newSucursal.getIdBanco()));
		// Comprobamos que no superemos el tope de sucursales
		if ((banco.getNumSucursales()+1)> maxSucursales)
			throw new MiValidationException("201","Ya hay "+maxSucursales+" sucursales en el banco "+banco.getId()+", no se puede añadir uno más");
		// Actualizamos el número de sucursales de los bancos
		banco.setNumSucursales(banco.getNumSucursales() + 1);
		bancoService.updateBanco(bancoMapper.bancoToBancoDto(banco));
		sucursal.setBanco(banco);
		sucursal = sucursalRepository.save(sucursal);
		return sucursalMapper.sucursalToSucursalDtoConBancoDto(sucursal);
	}

	@Override
	public SucursalDtoConBancoDto updateSucursal(Long idSucursal, NewSucursalDto newSucursal) throws MiValidationException {
		log.info("Actualizando una sucursal con id pasado por el path usando el bean {}", BEAN_NAME);
		try {
			Sucursal sucursal = sucursalRepository.getById(idSucursal);
			Banco bancoViejo = sucursal.getBanco();
			Banco bancoNuevo = bancoMapper.bancoDtoToBanco(bancoService.getBanco(newSucursal.getIdBanco()));			
			sucursal.setCodigo(newSucursal.getCodigo());
			sucursal.setDireccion(newSucursal.getDireccion());
			sucursal.setNombreDirector(newSucursal.getNombreDirector());			
			// Comprobamos si hubo algún cambio de banco en la actualización
			if (!bancoViejo.getId().equals(bancoNuevo.getId())) {
				bancoViejo.setNumSucursales(bancoViejo.getNumSucursales() - 1);
				bancoNuevo.setNumSucursales(bancoNuevo.getNumSucursales() + 1);
				bancoService.updateBanco(bancoMapper.bancoToBancoDto(bancoViejo));
				bancoService.updateBanco(bancoMapper.bancoToBancoDto(bancoNuevo));
			}
			sucursal.setBanco(bancoNuevo);
			sucursal = sucursalRepository.save(sucursal);
			return sucursalMapper.sucursalToSucursalDtoConBancoDto(sucursal);
		} catch (EntityNotFoundException enfe) {
			log.warn("No se encontró sucursal en actualización");
			throw new MiValidationException("404", "Sucursal con id " + idSucursal + " no encontrada");
		}
	}

	@Override
	public SucursalDtoConBancoDto updateSucursal(SucursalDto sucursalDto) throws MiValidationException {
		log.info("Actualizando una sucursal que recibimos a través del RequestBody usando el bean {}", BEAN_NAME);
		try {
			Sucursal sucursal = sucursalRepository.getById(sucursalDto.getId());
			Banco bancoViejo = sucursal.getBanco();
			Banco bancoNuevo = bancoMapper.bancoDtoToBanco(bancoService.getBanco(sucursalDto.getIdBanco()));			
			sucursal.setCodigo(sucursalDto.getCodigo());
			sucursal.setDireccion(sucursalDto.getDireccion());
			sucursal.setNombreDirector(sucursalDto.getNombreDirector());
			// Comprobamos si hubo algún cambio de banco en la actualización
			if (bancoViejo.getId() != bancoNuevo.getId()) {
				bancoViejo.setNumSucursales(bancoViejo.getNumSucursales() - 1);
				bancoNuevo.setNumSucursales(bancoNuevo.getNumSucursales() + 1);
				bancoService.updateBanco(bancoMapper.bancoToBancoDto(bancoViejo));
				bancoService.updateBanco(bancoMapper.bancoToBancoDto(bancoNuevo));
			}
			sucursal.setBanco(bancoNuevo);
			sucursal = sucursalRepository.save(sucursal);
			return sucursalMapper.sucursalToSucursalDtoConBancoDto(sucursal);
		} catch (EntityNotFoundException enfe) {
			log.warn("No se encontró sucursal en actualización");
			throw new MiValidationException("404", "Sucursal con id " + sucursalDto.getId() + " no encontrada");
		}
	}

	@Override
	public void deleteSucursal(Long idSucursal) throws MiValidationException {
		log.info("Eliminando una sucursal de la que recibimos el id por el path usando el bean {}", BEAN_NAME);
		Banco banco = sucursalRepository.getById(idSucursal).getBanco();
		sucursalRepository.deleteById(idSucursal);
		// Actualizamos el número de sucursales de los bancos
		banco.setNumSucursales(banco.getNumSucursales() - 1);
		bancoService.updateBanco(bancoMapper.bancoToBancoDto(banco));
	}

}
