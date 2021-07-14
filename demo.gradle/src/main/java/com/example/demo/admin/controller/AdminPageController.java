package com.example.demo.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.CodeVO;
import com.example.demo.domain.UserVO;
import com.example.demo.service.CodeService;
import com.example.demo.service.UserService;

@Controller
public class AdminPageController {
	
	@Autowired CodeService codeService;
	@Autowired UserService userService;

	@GetMapping("/admin/index")
	public String index(Model model) {
		model.addAttribute("menuId", "adminIndex");
		
		//List<UserVO> userList = userService.selectUserList();
		
		// JPA 테스트
		List<UserVO> userList = userService.findAll();
		
		model.addAttribute("userList", userList);

//		List<CodeVO> codeClassList = codeService.selectCodeClassList();
//		
//		for (CodeVO codeClass : codeClassList) {
//			List<CodeVO> codeItemsList = codeService.selectCodeItemsList(codeClass);
//			codeClass.setCodeItems(codeItemsList);
//		}
//	
//		model.addAttribute("codeClassList", codeClassList);
		
		return "admin/index";
	}

	@GetMapping("/admin/code/list")
	public String codeList(Model model) {
		model.addAttribute("menuId", "code");
		
		return "admin/code/list";
	}
	
	@GetMapping("/admin/diary/list")
	public String diaryList(Model model) {
		model.addAttribute("menuId", "diary");
	
		return "admin/diary/list";
	}
	
}
