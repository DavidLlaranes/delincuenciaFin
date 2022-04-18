package es.seresco.delincuencia.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CONTRATO", uniqueConstraints = {
		@UniqueConstraint(name = "CONTRATO_UK_0", columnNames = { "ID_SUCURSAL", "ID_VIGILANTE", "FECHA_INICIO" }) })
public class Contrato implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8701897683893933707L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "IDENTIFICADOR", nullable = false, length = 10, unique = true)
	private String identificador;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_INICIO", nullable = false)
	private Date fechaInicio;

	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_FIN", nullable = false)
	private Date fechaFin;

	@Column(name = "PERMISO_ARMAS", nullable = false, columnDefinition = "boolean default 0")
	private boolean permisoArmas;

	@ManyToOne
	@JoinColumn(name = "ID_SUCURSAL")
	private Sucursal sucursal;

	@ManyToOne
	@JoinColumn(name = "ID_VIGILANTE")
	private Vigilante vigilante;

	public Contrato() {
		super();
	}

	public Contrato(String identificador, Date fechaInicio, Date fechaFin, boolean permisoArmas) {
		super();
		this.identificador = identificador;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.permisoArmas = permisoArmas;
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

	public Date getFechaInicio() {
		return (Date) fechaInicio.clone();
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public boolean isPermisoArmas() {
		return permisoArmas;
	}

	public void setPermisoArmas(boolean permisoArmas) {
		this.permisoArmas = permisoArmas;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public Vigilante getVigilante() {
		return vigilante;
	}

	public void setVigilante(Vigilante vigilante) {
		this.vigilante = vigilante;
	}

}
