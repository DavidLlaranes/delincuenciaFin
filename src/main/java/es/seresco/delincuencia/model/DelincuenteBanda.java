package es.seresco.delincuencia.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "DELINCUENTE_BANDA")
@NoArgsConstructor@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class DelincuenteBanda implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 689374408817967840L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter@Setter(AccessLevel.PRIVATE)
	@ToString.Exclude
	private Integer id;	
	
	@Getter@Setter
	@ManyToOne()
	private Delincuente delincuente;
	
	@Getter@Setter
	@ManyToOne() //Qué pasa si cambiamos a LAZY??
	private BandaOrganizada banda;
	
/*	public DelincuenteBanda(Delincuente delincuente, BandaOrganizada banda) {
		Asociacion.EntrarEnBanda.link(delincuente, this, banda);
	}
*/
}

