package es.seresco.delincuencia.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TARJETA_CREDITO")
public class TarjetaCredito  extends ProductoBancario {

	private static final long serialVersionUID = 3702251723775207864L;

	@Column(name = "NUMERO_TARJETA", nullable = false, length = 30)
	private String numeroTarjeta;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "FECHA_CADUCIDAD", nullable = false)
	private Date fechaCaducidad;

	@Override
	public String toString() {
		return "TarjetaCredito [id="+super.getId()+", codigoBanco="+super.getBanco().getCodigo()+", nombre="+ super.getNombre()+", apellido1="+super.getApellido1()
			+", apellido2="+super.getApellido2()+", numeroTarjeta= "+ numeroTarjeta + ", fechaCaducidad=" + fechaCaducidad + "]";
	}	

}
