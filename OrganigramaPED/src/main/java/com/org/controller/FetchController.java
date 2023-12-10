package com.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.org_emp.entity.Departamentos;
import com.org.org_emp.entity.Empleado;
import com.org.org_emp.entity.NodoDepto;
import com.org.org_emp.entity.NodoEmpleado;
import com.org.service.Fetch_Service;

@RestController
public class FetchController {
	
	@Autowired
	Fetch_Service fetch_service;
	
	@PostMapping(value="/fetch-data/get_lista_empleados")
	public List<Empleado> getListaEmpleados(){
		return fetch_service.getListaEmpleados();
	}
	
	@PostMapping(value="/fetch-data/get_lista_departamentos")
	public List<Departamentos> getListaDepartamentos(){
		return fetch_service.getListaDeptos();
	}
	
	@PostMapping(value="/fetch-data/get_arbol_departamentos", produces = {"application/json"})
	public NodoDepto getArbolDepartamentos() {
		List<Departamentos> listaDeptos= fetch_service.getListaDeptos();
		NodoDepto raiz=fetch_service.construirArbolDepto(listaDeptos);
		
		return raiz;
	}
	

	@PostMapping(value="/fetch-data/get_arbol_empleados", produces = {"application/json"})
	public NodoEmpleado getArbolEmpleados() {
		List<Empleado> listaEmpleado= fetch_service.getListaEmpleados();
		NodoEmpleado raiz=fetch_service.construirArbol(listaEmpleado);
		
		return raiz;
	}
}
