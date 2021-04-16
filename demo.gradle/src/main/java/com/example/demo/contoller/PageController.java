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
	
	@GetMapping("/closet/gallery")
	public String closetGallery() {
		
		return "closet/gallery";
	}
	
	@GetMapping("/profile/view")
	public String profileView() {
		
		return "profile/view";
	}
	
	/*
	 * @GetMapping("/user/") public String userSignIn() {
	 * 
	 * return "user/sign_in"; }
	 */
	
	@GetMapping("/user/sign_in")
	public String userSignIn() {
		
		return "user/sign_in";
	}
	@GetMapping("/user/sign_up")
	public String userSignUp() {
		
		return "user/sign_up";
	}


}
