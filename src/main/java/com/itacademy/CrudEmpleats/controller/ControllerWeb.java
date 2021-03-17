package com.itacademy.CrudEmpleats.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerWeb {
	/*
	 * Controlador d'accés html
	 */
	
	@GetMapping("/index")
	public String goIndex() {
		return "index";
	}

	@GetMapping("/BodyHeader")
	public String bodyHeader() {
		return "BodyHeader";
	}

}
