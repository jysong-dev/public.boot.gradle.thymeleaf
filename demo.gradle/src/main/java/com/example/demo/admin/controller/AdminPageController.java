package com.example.demo.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPageController {

	@GetMapping("/admin/index")
	public String index() {
	
		return "admin/index";
	}
	
	@GetMapping("/admin/profile/form")
	public String profileForm() {
	
		return "admin/profile/form";
	}
	
	
}
