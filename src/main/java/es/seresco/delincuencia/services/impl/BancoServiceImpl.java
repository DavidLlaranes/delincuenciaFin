package es.seresco.delincuencia.services.impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.seresco.delincuencia.controller.dto.BancoDto;
import es.seresco.delincuencia.controller.dto.NewBancoDto;
import es.seresco.delincuencia.exceptions.MiValidationException;
import es.seresco.delincuencia.mapper.BancoMapper;
import es.seresco.delincuencia.model.Banco;
import es.seresco.delincuencia.repository.BancoRepository;
import es.seresco.delincuencia.services.BancoService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BancoServiceImpl implements BancoService {

	private static final String BEAN_NAME = "BancoServiceImpl";

	@Autowired
	private BancoRepository bancoRepository;

	@Autowired
	private BancoMapper bancoMapper;

	@Override
	public BancoDto getBanco(Long idBanco) {
		log.info("Buscando el banco {}", idBanco);
		Banco banco = bancoRepository.getById(idBanco);
		return bancoMapper.bancoToBancoDto(banco);
	}

	@Override
	public BancoDto create(NewBancoDto newBanco) {
		log.info("Usando bean {} para crear banco", BEAN_NAME);
		Banco banco = bancoMapper.newBancoDtoToBanco(newBanco);
		banco.setCodigo(newBanco.getCodigo());
		banco.setSede(newBanco.getSede());
		banco.setNumSucursales(newBanco.getNumSucursales());
		banco = bancoRepository.save(banco);
		return bancoMapper.bancoToBancoDto(banco);
	}

	@Override
	public List<BancoDto> getBancos() {
		log.info("Usando bean {} para encontrar todos los bancos", BEAN_NAME);
		List<Banco> bancos = bancoRepository.findAll();
		return bancoMapper.bancoTomapBancoDtoList(bancos);
	}

	@Override
	public BancoDto updateBanco(Long idBanco, NewBancoDto newBanco) throws MiValidationException {
		log.info("Usando bean {} para actualizar un banco pasándole una id", BEAN_NAME);
		try {
			Banco banco = bancoRepository.getById(idBanco);
			banco.setCodigo(newBanco.getCodigo());
			banco.setSede(newBanco.getSede());
			banco.setNumSucursales(newBanco.getNumSucursales());
			bancoRepository.save(banco);
			return bancoMapper.bancoToBancoDto(banco);
		} catch (EntityNotFoundException enfe) {
			log.warn("No se encontró banco en actualización");
			throw new MiValidationException("201", "Banco con id "+idBanco+" no encontrado");
		}

	}

	@Override
	public BancoDto updateBanco(BancoDto bancoDto) throws MiValidationException {
		log.info("Usando bean {} para actualizar un banco", BEAN_NAME);
		try {
			Banco banco = bancoRepository.getById(bancoDto.getId());
			banco.setCodigo(bancoDto.getCodigo());
			banco.setSede(bancoDto.getSede());
			banco.setNumSucursales(bancoDto.getNumSucursales());
			bancoRepository.save(banco);
			return bancoMapper.bancoToBancoDto(banco);
		} catch (EntityNotFoundException enfe) {
			log.warn("No se encontró banco en actualización");
			throw new MiValidationException("201", "Banco con id "+bancoDto.getId()+" no encontrado");
		}
	}

	@Override
	public void deleteBanco(Long idBanco) {
		log.info("Usando bean {} para actualizar un banco pasándole una id {}", BEAN_NAME, idBanco);
		bancoRepository.deleteById(idBanco);
	}

}
