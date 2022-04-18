package es.seresco.delincuencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "SUCURSAL")
public class Sucursal implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4347117274148071411L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODIGO", nullable = false, length = 10, unique = true)
	private String codigo;

	@Column(name = "DIRECCION", nullable = false, length = 50)
	private String direccion;

	@Column(name = "NOMBRE_DIRECTOR", nullable = false, length = 100)
	private String nombreDirector;

//	@Column(name = "NUM_TRABAJADORES", nullable = false, columnDefinition = "int default 0")
//	private int numTrabajadores;

	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "ID_BANCO")
	private Banco banco;

/*	@ToString.Exclude
	@Getter(AccessLevel.NONE)
	@OneToMany(mappedBy = "sucursal")
	private List<Atraco> atracos = new ArrayList<Atraco>();

	@ToString.Exclude
	@Getter(AccessLevel.NONE)
	@OneToMany(mappedBy = "sucursal")
	private List<Contrato> contratos = new ArrayList<Contrato>();
	
	*/
	public Sucursal(String codigo, String direccion, String nombreDirector) {
		super();
		this.codigo = codigo;
		this.direccion = direccion;
		this.nombreDirector = nombreDirector;
	}

/*	List<Atraco> _getAtracos() {
		return this.atracos;
	}

	List<Contrato> _getContratos() {
		return this.contratos;
	}

	public List<Atraco> getAtracos() {
		return new ArrayList<Atraco>(atracos);
	}

	public List<Contrato> getContratos() {
		return new ArrayList<Contrato>(contratos);
	}

	public void addAtraco(Atraco atraco) {
		Asociacion.SucursalAtracada.link(this, atraco);
	}

	public void addContrato(Contrato contrato) {
		Asociacion.AsignarVigilancia.link(this, contrato);
	}
*/
}
