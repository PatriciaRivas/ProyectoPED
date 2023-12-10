package com.org.org_emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Codigo")
	private String codigo;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Apellido")
	private String apellido;
	
	@Column(name="Puesto")
	private String puesto;
	
	@Column(name="IdJefe")
	private Integer idJefe;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Integer getIdJefe() {
		return idJefe;
	}

	public void setIdJefe(Integer idJefe) {
		this.idJefe = idJefe;
	}
	
	
}
