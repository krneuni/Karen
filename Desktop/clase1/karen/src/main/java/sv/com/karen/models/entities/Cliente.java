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
@Table(name="clientes")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "clientes_Seq")
	@SequenceGenerator(name = "clientes_Seq", sequenceName = "CLIENTES_SEQ")
	private Long id; 
	
	@Column(name="NombreCliente")
	@NotEmpty
	private String NombreCliente;
	
	@Column(name="Edad")
	//@NotEmpty
	private int Edad;
	
	@NotEmpty
	@Column(name="direccion")
	@NotEmpty
	private String dir_cliente;
	
	@NotEmpty
	@Column(name="telefono")
	@NotEmpty
	private String tel_cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return NombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		NombreCliente = nombreCliente;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public String getDir_cliente() {
		return dir_cliente;
	}

	public void setDir_cliente(String dir_cliente) {
		this.dir_cliente = dir_cliente;
	}

	public String getTel_cliente() {
		return tel_cliente;
	}

	public void setTel_cliente(String tel_cliente) {
		this.tel_cliente = tel_cliente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}