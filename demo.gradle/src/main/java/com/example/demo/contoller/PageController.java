package com.example.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PageController {
	
    @GetMapping("/{userId}")
    public String index(@PathVariable("userId") String userId, Model model){
    	
    	if (!"favicon.ico".equals(userId)) {
    		System.out.println("유저 아이디:" + userId);
    	}
    	//model.addAttribute(attributeValue);
    	// 위젯 목록
    	
        return "index";
    }
	
	@GetMapping("/diary/list")
	public String diaryList() {
		
		return "diary/list";
	}
	
	@GetMapping("/diary/view")
	public String diaryView() {
		
		return "diary/view";
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
