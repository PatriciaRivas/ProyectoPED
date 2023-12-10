package com.org.org_emp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.org.org_emp.entity.Empleado;

public interface I_Empleado extends CrudRepository<Empleado, Integer> {

	@Query(nativeQuery = true, value="SELECT MAX(Id) FROM Empleado")
	public Integer getMaxEmpleadoCorrelativo();
}
