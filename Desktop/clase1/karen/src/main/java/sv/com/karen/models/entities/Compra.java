package sv.com.karen.models.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="compras")
public class Compra implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "compras_Seq")
	@SequenceGenerator(name = "compras_Seq", sequenceName = "COMPRAS_SEQ")
	private Long id; 
	
	@Column(name="FechaCompra")
	//@NotEmpty
	private Date FechaCompra;
	
	@Column(name="PrecioUnitario")
	//@NotEmpty
	private float PrecioUnitario;
	
	@NotEmpty
	@Column(name="ProductoPedido")
	@NotEmpty
	private String ProductoPedido;
	
	@NotEmpty
	@Column(name="ProductoRecibido")
	@NotEmpty
	private String ProductoRecibido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFechaCompra() {
		return FechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		FechaCompra = fechaCompra;
	}

	public float getPrecioUnitario() {
		return PrecioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		PrecioUnitario = precioUnitario;
	}

	public String getProductoPedido() {
		return ProductoPedido;
	}

	public void setProductoPedido(String productoPedido) {
		ProductoPedido = productoPedido;
	}

	public String getProductoRecibido() {
		return ProductoRecibido;
	}

	public void setProductoRecibido(String productoRecibido) {
		ProductoRecibido = productoRecibido;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}