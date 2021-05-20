package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
	
    @GetMapping("/")
    public String index(){
        return "index";
    }
	
	@GetMapping("/closet/list")
	public String closetList() {
		
		return "closet/list";
	}
	
	@GetMapping("/closet/view")
	public String closetView() {
		
		return "closet/view";
	}
	
//	@GetMapping("/closet/gallery")
//	public String closetGallery() {
//		
//		return "closet/gallery";
//	}
	
	@GetMapping("/profile/view")
	public String profileView() {
		
		return "profile/view";
	}
	
	@GetMapping("/search/list")
	public String searchList() {
		
		return "search/list";
	}

	@GetMapping("/demo/table_reorder")
	public String tableReorder() {
		
		return "demo/table-reorder-example";
	}
	

}
