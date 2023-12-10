package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.org.org_emp.dao.I_Departamento;
import com.org.org_emp.dao.I_Empleado;
import com.org.org_emp.entity.Departamentos;
import com.org.org_emp.entity.Empleado;

@Controller
public class Transact_Service_Impl implements Transact_Service {

	@Autowired
	private I_Departamento depto_dao;
	
	@Autowired
	private I_Empleado empleado_dao;
	
	@Override
	public void saveEmpleado(Empleado empleado) {
		empleado_dao.save(empleado);
	}

	@Override
	public void saveDepartamento(Departamentos depto) {
		depto_dao.save(depto);
	}

}
