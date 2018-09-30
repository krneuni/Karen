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
@Table(name="productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "productos_Seq")
	@SequenceGenerator(name = "productos_Seq", sequenceName = "PRODUCTOS_SEQ")
	private Long id; 
	
	@Column(name="Nombre")
	@NotEmpty
	private String Nombre;
	
	@Column(name="PrecioCompra")
	//@NotEmpty
	private float PrecioCompra;
	
	
	@Column(name="PrecioVenta")
	//@NotEmpty
	private float PrecioVenta;
	
	
	@Column(name="FechaVenc")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	//@NotEmpty
	private Date FechaVenc;
	
	
	@Column(name="Estado")
	//@NotEmpty
	private String Estado;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public float getPrecioCompra() {
		return PrecioCompra;
	}


	public void setPrecioCompra(float precioCompra) {
		PrecioCompra = precioCompra;
	}


	public float getPrecioVenta() {
		return PrecioVenta;
	}


	public void setPrecioVenta(float precioVenta) {
		PrecioVenta = precioVenta;
	}


	public Date getFechaVenc() {
		return FechaVenc;
	}


	public void setFechaVenc(Date fechaVenc) {
		FechaVenc = fechaVenc;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		Estado = estado;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}