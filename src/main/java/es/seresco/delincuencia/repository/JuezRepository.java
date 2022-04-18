package es.seresco.delincuencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.seresco.delincuencia.model.Juez;

@Repository
public interface JuezRepository extends JpaRepository <Juez, Long> {

}
