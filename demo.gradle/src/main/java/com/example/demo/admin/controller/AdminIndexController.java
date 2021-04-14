package com.example.demo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/admin")
public class AdminIndexController {

	public String index() {
	
		return "admin/index";
	}
	
	
}
