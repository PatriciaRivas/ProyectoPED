package com.org.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.org_emp.entity.Departamentos;
import com.org.org_emp.entity.Empleado;
import com.org.service.Fetch_Service;
import com.org.service.Transact_Service;

@RestController
public class TransactController {
	
	@Autowired
	private Fetch_Service fetch_service;
	
	@Autowired
	private Transact_Service transact_service;

	@PostMapping("/transaction/save_empleado")
	public Map<String, String> guardarEmpleado(@RequestParam String nombre, @RequestParam String apellido, @RequestParam String puesto, @RequestParam Integer idJefe){
		Map<String, String> msg= new HashMap<String, String>();
		Empleado empleado= new Empleado();
		Integer correlativo= fetch_service.maxEmpleado();
		
		String codigoEmp= "EMP"+String.format("%03d", correlativo);
		empleado.setNombre(nombre);
		empleado.setApellido(apellido);
		empleado.setPuesto(puesto);
		empleado.setIdJefe(idJefe);
		empleado.setCodigo(codigoEmp);
		
		transact_service.saveEmpleado(empleado);
		msg.put("code","0");
		msg.put("msg", "Empleado guardado!");
		return msg;
	}
	
	@PostMapping("/transaction/save_departamento")
	public Map<String, String> guardarDepartamento(@RequestParam String departamento, @RequestParam Integer deptoJefe){
		Map<String, String> msg= new HashMap<String, String>();
		Departamentos depto= new Departamentos();
		Integer correlativo= fetch_service.maxDepartamento();
		
		String codigoDep= "DEP"+String.format("%03d", correlativo);
		depto.setCodigo(codigoDep);
		depto.setDepartamento(departamento);
		depto.setIdDeptoJefe(deptoJefe);
		
		transact_service.saveDepartamento(depto);
		
		msg.put("code", "0");
		msg.put("msg", "Departamento guardado!");
		
		return msg;
	}
}
