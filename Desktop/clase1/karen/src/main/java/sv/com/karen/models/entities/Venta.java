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
@Table(name="ventas")
public class Venta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "compras_Seq")
	@SequenceGenerator(name = "compras_Seq", sequenceName = "COMPRAS_SEQ")
	private Long id; 
	
	
	
	@Column(name="numfactura")
	@NotEmpty
	private String numfactura;
	
	@Column(name="FechaVenta")
	//@NotEmpty
	private Date FechaVenta;
	
	@Column(name="PrecioVenta")
	//@NotEmpty
	private float PrecioVenta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumfactura() {
		return numfactura;
	}

	public void setNumfactura(String numfactura) {
		this.numfactura = numfactura;
	}

	public Date getFechaVenta() {
		return FechaVenta;
	}

	public void setFechaVenta(Date fechaVenta) {
		FechaVenta = fechaVenta;
	}

	public float getPrecioVenta() {
		return PrecioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		PrecioVenta = precioVenta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}