package es.seresco.delincuencia.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BANCO")
public class Banco implements Serializable {

	
	private static final long serialVersionUID = -5303145511746498228L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CODIGO", nullable = false, length = 10, unique = true)
	private String codigo;

	@Column(name = "SEDE", nullable = false, length = 50)
	private String sede;
	
	@Column (name = "NUM_SUCURSALES", nullable = false)
	private int numSucursales;

/*	@OneToMany(mappedBy = "banco")
	private List<Sucursal> sucursales = new ArrayList<Sucursal>();
	
	@OneToMany(mappedBy = "banco")
	private List <ProductoBancario> productoBancarios = new ArrayList <ProductoBancario>();*/

/*	public Banco() {
		super();
	}

	public Banco(String codigo, String sede) {
		super();
		this.codigo = codigo;
		this.sede = sede;
	}

	public Long getId() {
		return id;
	}
	
	public void setId (Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}*/

/*	public int getNumSucursales() {
		return sucursales.size();
	}*/

	/* //método público que devuelve una copia de la lista de sucursales
	public List<Sucursal> getSucursales() {
		return new ArrayList<Sucursal>(sucursales);
	}*/

/*	//método privado que devuelve las sucursales
	List<Sucursal> _getSucursales() {
		return sucursales;
	}*/
	
/*	//método público que devuelve una copia de la lista de productos bancarios
	public List <ProductoBancario> getProductoBancarios() {
		return new ArrayList<ProductoBancario> (productoBancarios);
	}
	*/
/*	// Método que devuelve la lista de productos bancarios para poder modificarlos
	protected List <ProductoBancario> _getProductoBancarios() {
		return productoBancarios;
	}

	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}*/

/*	@Override
	public String toString() {
		return "Banco [id=" + id + ", codigo=" + codigo + ", sede=" + sede + "]";
	}
*/
/*	public void addSucursal(Sucursal sucursal) {
		Asociacion.Pertenece.link(this, sucursal);
	}
	
	public void removeSucursal(Sucursal sucursal) {
		Asociacion.Pertenece.unlink(this, sucursal);
	}
	
	public void addProductoBancario (ProductoBancario productoBancario) {
		Asociacion.ContratarProducto.link(this, productoBancario);
	}
	
	public void removeProductoBancario (ProductoBancario productoBancario) {
		Asociacion.ContratarProducto.unlink(this, productoBancario);
	}*/

}
