package com.org.org_emp.entity;

import java.util.ArrayList;
import java.util.List;

public class NodoEmpleado {
	private Empleado empleado;
    private List<NodoEmpleado> subordinados;

    public NodoEmpleado(Empleado empleado) {
        this.empleado = empleado;
        this.subordinados = new ArrayList<>();
    }

	public void addSubordinados(NodoEmpleado subordinado) {
		this.subordinados.add(subordinado);
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<NodoEmpleado> getSubordinados() {
		return subordinados;
	}
	
    
}
