package es.seresco.delincuencia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import es.seresco.delincuencia.model.tipos.TipoCondena;

@Entity
@Table(name = "ATRACO")
public class Atraco implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5807833637568906534L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA", nullable = false)
	private Date fecha;

	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_CONDENA", nullable = true, length = 100)
	private TipoCondena tipoCondena;

	@ManyToOne
	@JoinColumn(name = "ID_SUCURSAL", referencedColumnName = "id")
	private Sucursal sucursal;

	@ManyToOne
	@JoinColumn(name = "ID_DELINCUENTE")
	private Delincuente delincuente;

	@ManyToOne
	@JoinColumn(name = "ID_JUEZ")
	private Juez juez;

	public Atraco() {
		super();
	}

	public Atraco(Date fecha) {
		super();
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public Date getFecha() {
		return (Date) fecha.clone();
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TipoCondena getTipoCondena() {
		return tipoCondena;
	}

	public void setTipoCondena(TipoCondena tipoCondena) {
		this.tipoCondena = tipoCondena;
	}
/*	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Delincuente getDelincuente() {
		return delincuente;
	}

	public void setDelincuente(Delincuente delincuente) {
		this.delincuente = delincuente;
	}

	public Juez getJuez() {
		return juez;
	}

	public void setJuez(Juez juez) {
		this.juez = juez;
	}

	@Override
	public String toString() {
		return "Atraco [id=" + id + ", fecha=" + fecha + ", tipoCondena=" + tipoCondena + ", delincuente=" + delincuente.getNombre()
				+ "]";
	}
	*/
	

}
