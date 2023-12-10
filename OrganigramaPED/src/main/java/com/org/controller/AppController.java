package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.org.service.Fetch_Service;


@Controller
public class AppController {
	
	@Autowired
	Fetch_Service fetch_service;

	
	@GetMapping("/login")
	public String getVistaLogin(Model model) {
		return "Portal/Login";
	}
	
	@GetMapping({"/home","/"})
	public String getVistaPrincipal() {
		return "Portal/Home";
	}
	
	@GetMapping({"/Departamentos"})
	public String getVistaDepartamentos() {
		return "Portal/Depto";
	}
}
