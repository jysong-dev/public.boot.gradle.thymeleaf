package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/")
public class HomeController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		
		model.addAttribute("name", name);
		return "greeting/greeting";
	}
	
	@GetMapping("/closet/list")
	public String closetList() {
		
		return "closet/list";
	}
	
}
