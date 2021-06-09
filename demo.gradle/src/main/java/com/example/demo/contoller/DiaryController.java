package com.example.demo.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.domain.PrototypeMasterVO;
import com.example.demo.domain.UserVO;
import com.example.demo.service.PrototypeMasterService;
import com.example.demo.service.UserService;

@Controller
public class DiaryController {
	
	@Autowired
	PrototypeMasterService prototypeMasterService;
	
	@Autowired
	UserService userService;

	@GetMapping("/{userId}/diary/list")
	public String diaryList(@PathVariable("userId") String userId, Model model) {
		
    	addUserModelAttribute(userId, model);
		
		return "diary/list";
	}
	
	@GetMapping("/{userId}/diary/view")
	public String diaryView(@PathVariable("userId") String userId, Model model) {
		
		addUserModelAttribute(userId, model);
		
		return "diary/view";
	}
	
    public void addUserModelAttribute(String userId, Model model) {
    	UserVO userVO = new UserVO();
    	userVO.setUserId(userId);
    	UserVO userInfo = userService.findByUserId(userVO);
    	
    	PrototypeMasterVO prototypeMasterVO = new PrototypeMasterVO();
    	prototypeMasterVO.setUserKey(userInfo.getUserKey());
    	PrototypeMasterVO prototypeMasterInfo = prototypeMasterService.findByUserKey(prototypeMasterVO);
    	
    	model.addAttribute("userInfo", userInfo);
    }
	
}
