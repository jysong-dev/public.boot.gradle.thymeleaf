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
public class SettingController {
	
	@Autowired
	PrototypeMasterService prototypeMasterService;
	
	@Autowired
	UserService userService;

	@GetMapping("/admin/settings/form-account")
	public String settingForm(Model model) {

		return "admin/settings/form_account";
	}
	
	@GetMapping("/admin/settings/form_prototype")
	public String settingFormPrototype(Model model) {
		model.addAttribute("menuId", "settings");
	
		return "admin/settings/form_prototype";
	}
	
}
