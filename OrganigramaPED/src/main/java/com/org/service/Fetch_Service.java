package com.org.service;

import java.util.List;

import com.org.org_emp.entity.Departamentos;
import com.org.org_emp.entity.Empleado;
import com.org.org_emp.entity.NodoDepto;
import com.org.org_emp.entity.NodoEmpleado;

public interface Fetch_Service {

	public List<Empleado> getListaEmpleados();
	
	public NodoEmpleado construirArbol(List<Empleado> empleados);
	
	public List<Departamentos> getListaDeptos();
	
	public NodoDepto construirArbolDepto(List<Departamentos> departamentos);
	
	public Integer maxEmpleado();
	
	public Integer maxDepartamento();
}
