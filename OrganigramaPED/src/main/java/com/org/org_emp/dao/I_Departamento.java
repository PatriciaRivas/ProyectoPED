package com.org.org_emp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.org.org_emp.entity.Departamentos;

public interface I_Departamento extends CrudRepository<Departamentos, Integer> {

	@Query(nativeQuery = true, value="SELECT MAX(Id) FROM Departamentos")
	public Integer getMaxDepartamentoCorrelativo();
}
