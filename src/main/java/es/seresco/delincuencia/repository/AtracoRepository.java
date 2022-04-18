package es.seresco.delincuencia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import es.seresco.delincuencia.model.Atraco;

@Repository
public interface AtracoRepository extends JpaRepository <Atraco, Long> {

	@Query(value = "SELECT * FROM ATRACO WHERE ID_JUEZ = ?1", nativeQuery = true)
	List <Atraco> findByJuezId (Long idJuez);
	
}
