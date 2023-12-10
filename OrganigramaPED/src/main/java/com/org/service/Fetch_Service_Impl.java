package com.org.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.org_emp.dao.I_Departamento;
import com.org.org_emp.dao.I_Empleado;
import com.org.org_emp.entity.Departamentos;
import com.org.org_emp.entity.Empleado;
import com.org.org_emp.entity.NodoDepto;
import com.org.org_emp.entity.NodoEmpleado;

@Service
public class Fetch_Service_Impl implements Fetch_Service {

	@Autowired
	private I_Empleado empleado_dao;
	
	@Autowired
	private I_Departamento depto_dao;
	
	@Override
	public List<Empleado> getListaEmpleados() {
		return (List<Empleado>) empleado_dao.findAll();
	}
	
	@Override
	public NodoEmpleado construirArbol(List<Empleado> empleados) {
        Map<Integer, NodoEmpleado> mapaEmpleados = new HashMap<>();
        
        for (Empleado empleado : empleados) {
            NodoEmpleado nodo = new NodoEmpleado(empleado);
            mapaEmpleados.put(empleado.getId(), nodo);
        }

        for (Empleado empleado : empleados) {
            if (empleado.getIdJefe() != 0) {
                NodoEmpleado jefe = mapaEmpleados.get(empleado.getIdJefe());
                if (jefe != null) {
                    jefe.addSubordinados(mapaEmpleados.get(empleado.getId()));
                }
            }
        }

        return mapaEmpleados.get(1);
    }

	@Override
	public List<Departamentos> getListaDeptos() {
		return (List<Departamentos>) depto_dao.findAll();
	}

	@Override
	public NodoDepto construirArbolDepto(List<Departamentos> departamentos) {
		Map<Integer, NodoDepto> mapaDeptos = new HashMap<>();
        
        for (Departamentos depto : departamentos) {
            NodoDepto nodo = new NodoDepto(depto);
            mapaDeptos.put(depto.getId(), nodo);
        }

        for (Departamentos depto : departamentos) {
            if (depto.getIdDeptoJefe() != 0) {
                NodoDepto jefe = mapaDeptos.get(depto.getIdDeptoJefe());
                if (jefe != null) {
                    jefe.addSubordinados(mapaDeptos.get(depto.getId()));
                }
            }
        }

        return mapaDeptos.get(1);
	}

	@Override
	public Integer maxEmpleado() {
		return empleado_dao.getMaxEmpleadoCorrelativo();
	}

	@Override
	public Integer maxDepartamento() {
		return depto_dao.getMaxDepartamentoCorrelativo();
	}
}
