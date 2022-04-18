package es.seresco.delincuencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.seresco.delincuencia.model.Banco;

@Repository
public interface BancoRepository extends JpaRepository <Banco, Long> {
	
}
