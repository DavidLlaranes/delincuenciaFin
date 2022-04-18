package es.seresco.delincuencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DELINCUENTE")
public class Delincuente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7087331123973362373L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IDENTIFICADOR", nullable = false, length = 10, unique = true)
	private String identificador;

	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;
	
/*	@OneToMany(mappedBy = "delincuente")
	private Set<DelincuenteBanda> delincuenteBanda;

	@OneToMany(mappedBy = "delincuente")
	private List<Atraco> atracos = new ArrayList<Atraco>();*/

	public Delincuente() {
		super();
	}

	public Delincuente(String identificador, String nombre) {
		this.identificador = identificador;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

/*	List<Atraco> _getAtracos() {
		return this.atracos;
	}

	public void addAtraco(Atraco atraco) {
		Asociacion.Delinquir.link(this, atraco);
	}*/

}
