package com.example.demo.contoller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.CodeVO;

@Controller
public class ProfileController {
	
	@GetMapping("/admin/profile/form")
	public String profileForm(Model model) {
		model.addAttribute("menuId", "profile");

		return "admin/profile/form";
	}
	
	

}
