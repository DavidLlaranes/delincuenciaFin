package es.seresco.delincuencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VIGILANTE")
public class Vigilante implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7901671813878211299L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODIGO", nullable = false, length = 10, unique = true)
	private String codigo;

	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;

/*	@OneToMany(mappedBy = "vigilante")
	private List<Contrato> contratos = new ArrayList<Contrato>();
*/
	public Vigilante() {
		super();
	}

	public Vigilante(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
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
/*
	List<Contrato> _getContratos() {
		return this.contratos;
	}

	public void addContrato(Contrato contrato) {
		Asociacion.Contratar.link(this, contrato);
	}
*/
}
