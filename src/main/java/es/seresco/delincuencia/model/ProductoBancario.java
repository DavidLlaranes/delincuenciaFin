package es.seresco.delincuencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PRODUCTO_BANCARIO")
public abstract class ProductoBancario implements Serializable {

	private static final long serialVersionUID = 851104004378269928L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.PRIVATE)
	private Long id;

	@Column(name = "NOMBRE", nullable = false, length = 30)
	private String nombre;
	
	@Column(name = "APELLIDO1", nullable = false, length = 30)
	private String apellido1;
	
	@Column(name = "APELLIDO2", nullable = false, length = 30)
	private String apellido2;
	
	@ToString.Exclude
	@ManyToOne
	@JoinColumn(name = "ID_BANCO")
	private Banco banco;	
	
}
