package es.seresco.delincuencia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "CUENTA_BANCARIA")
public class CuentaBancaria extends ProductoBancario {

	private static final long serialVersionUID = 3508847292842374153L;
	
	@Column(name = "NUMERO_CUENTA", nullable = false, length = 30)
	private String numeroCuenta;
	
	@Column(name = "SWIFT", nullable = false)
	private String swift;

	@Override
	public String toString() {
		return "CuentaBancaria [id="+super.getId()+", codigoBanco="+super.getBanco().getCodigo()+", nombre="+ super.getNombre()+", apellido1="+super.getApellido1()
				+ ", apellido2="+super.getApellido2()+", numeroCuenta=" + numeroCuenta + ", swift=" + swift + "]";
	}
	

}
