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
@Table(name="proveedores")
public class Proveedor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "proveedores_Seq")
	@SequenceGenerator(name = "proveedores_Seq", sequenceName = "PROVEEDORES_SEQ")
	private Long id; 
	
	@Column(name="proveedor_emp")
	@NotEmpty
	private String proveedorName;
	
	@Column(name="nit")
	//@NotEmpty
	private int nit_emp;
	
	@NotEmpty
	@Column(name="direccion")
	@NotEmpty
	private String dir_emp;
	
	@NotEmpty
	@Column(name="telefono")
	@NotEmpty
	private String tel_emp;

	
	@NotEmpty
	@Column(name="email")
	@NotEmpty
	private String email;
	
	@NotEmpty
	@Column(name="nombre_contacto")
	@NotEmpty
	private String nombre_contacto;
	
	@Column(name="tel_contacto")
	@NotEmpty
	private String tel_contacto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProveedorName() {
		return proveedorName;
	}

	public void setProveedorName(String proveedorName) {
		this.proveedorName = proveedorName;
	}

	public int getNit_emp() {
		return nit_emp;
	}

	public void setNit_emp(int nit_emp) {
		this.nit_emp = nit_emp;
	}

	public String getDir_emp() {
		return dir_emp;
	}

	public void setDir_emp(String dir_emp) {
		this.dir_emp = dir_emp;
	}

	public String getTel_emp() {
		return tel_emp;
	}

	public void setTel_emp(String tel_emp) {
		this.tel_emp = tel_emp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre_contacto() {
		return nombre_contacto;
	}

	public void setNombre_contacto(String nombre_contacto) {
		this.nombre_contacto = nombre_contacto;
	}

	public String getTel_contacto() {
		return tel_contacto;
	}

	public void setTel_contacto(String tel_contacto) {
		this.tel_contacto = tel_contacto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}


