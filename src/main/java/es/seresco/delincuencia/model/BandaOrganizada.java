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
@Table(name = "BANDA_ORGANIZADA")
public class BandaOrganizada implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5644197328475561675L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODIGO", nullable = false, length = 10, unique = true)
	private String codigo;

	@Column(name = "NUM_MIEMBROS", nullable = false, columnDefinition = "int default 0")
	private int numMiembros;
	
/*	@OneToMany(mappedBy = "banda")
	private Set<DelincuenteBanda> delincuenteBanda;*/

	public BandaOrganizada() {
		super();
	}

	public BandaOrganizada(String codigo, int numMiembros) {
		super();
		this.codigo = codigo;
		this.numMiembros = numMiembros;
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

	public int getNumMiembros() {
		return numMiembros;
	}

	public void setNumMiembros(int numMiembros) {
		this.numMiembros = numMiembros;
	}
}
