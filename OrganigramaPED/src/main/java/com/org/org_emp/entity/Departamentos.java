package com.org.org_emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Departamentos")
public class Departamentos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Integer id;
	
	@Column(name="Codigo")
	private String codigo;
	
	@Column(name="Departamento")
	private String departamento;
	
	@Column(name="IdDeptoJefe")
	private Integer idDeptoJefe;

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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Integer getIdDeptoJefe() {
		return idDeptoJefe;
	}

	public void setIdDeptoJefe(Integer idDeptoJefe) {
		this.idDeptoJefe = idDeptoJefe;
	}
}
