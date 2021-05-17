package com.example.demo.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.CodeVO;
import com.example.demo.service.CodeService;

@Controller
public class AdminPageController {
	
	@Autowired CodeService codeService;
	

	@GetMapping("/admin/index")
	public String index(Model model) {

		List<CodeVO> codeClassList = codeService.selectCodeClassList();
		
		for (CodeVO codeClass : codeClassList) {
			List<CodeVO> codeItemsList = codeService.selectCodeItemsList(codeClass);
			codeClass.setCodeItems(codeItemsList);
		}
	
		model.addAttribute("codeClassList", codeClassList);
		
		return "admin/index";
	}

	@GetMapping("/admin/code/list")
	public String codeList() {
	
		return "admin/code/list";
	}
	
	@GetMapping("/admin/index/form")
	public String indexForm() {
	
		return "admin/index/form";
	}
	
	@GetMapping("/admin/diary/list")
	public String diaryList() {
	
		return "admin/diary/list";
	}
	
	@GetMapping("/admin/settings/form_prototype")
	public String settingFormPrototype() {
	
		return "admin/settings/form_prototype";
	}
	
}
