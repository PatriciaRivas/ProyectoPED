package com.org.service;

import com.org.org_emp.entity.Departamentos;
import com.org.org_emp.entity.Empleado;

public interface Transact_Service {
	
	public void saveEmpleado(Empleado empleado);
	
	public void saveDepartamento(Departamentos depto);
}
