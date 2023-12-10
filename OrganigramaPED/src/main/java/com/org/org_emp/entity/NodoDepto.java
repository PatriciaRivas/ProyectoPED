package com.org.org_emp.entity;

import java.util.ArrayList;
import java.util.List;

public class NodoDepto {
	private Departamentos departamento;
    private List<NodoDepto> subordinados;

    public NodoDepto(Departamentos departamento) {
        this.departamento = departamento;
        this.subordinados = new ArrayList<>();
    }

	public void addSubordinados(NodoDepto subordinado) {
		this.subordinados.add(subordinado);
	}

	public Departamentos getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamentos departamento) {
		this.departamento = departamento;
	}

	public List<NodoDepto> getSubordinados() {
		return subordinados;
	}
}
