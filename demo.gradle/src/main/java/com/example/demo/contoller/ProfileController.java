package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
	
	@GetMapping("/admin/profile/form")
	public String profileForm(Model model) {
		model.addAttribute("menuId", "profile");

		return "admin/profile/form";
	}

}
