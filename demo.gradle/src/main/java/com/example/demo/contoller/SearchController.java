package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

	@GetMapping("/search/list")
	public String searchList() {
		
		return "search/list";
	}
	
}
