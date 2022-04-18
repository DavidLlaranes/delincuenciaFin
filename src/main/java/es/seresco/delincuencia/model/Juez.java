package es.seresco.delincuencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JUEZ")
public class Juez implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4610606391379915543L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IDENTIFICADOR", nullable = false, length = 10, unique = true)
	private String codigo;

	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;

/*	@OneToMany(mappedBy = "juez")
	private List<Atraco> atracos = new ArrayList<Atraco>();
*/
	public Juez() {
		super();
	}

	public Juez(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

/*	public List<Atraco> getAtracos() {
		return new ArrayList<Atraco>(atracos);
	}

	List<Atraco> _getAtracos() {
		return this.atracos;
	}

	public void setAtracos(List<Atraco> atracos) {
		this.atracos = atracos;
	}

	public void addAtraco(Atraco atraco) {
		Asociacion.Juzgar.link(this, atraco);
	}
*/
}
