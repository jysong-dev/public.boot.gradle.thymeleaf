package com.example.demo.admin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.domain.FileVO;
import com.example.demo.domain.UserVO;
import com.example.demo.service.FileService;
import com.example.demo.service.UserService;

@Controller
public class AdminPageController {
	
//	@Autowired
//	CodeService codeService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FileService fileService;

	@GetMapping("/admin/index")
	public String index(Model model, HttpSession session) {
		
		try {
			model.addAttribute("menuId", "adminIndex");
			
			UserVO userVO = (UserVO) session.getAttribute("userInfo");
			if (userVO == null) {
				return "redirect:/user/sign_in";
			} else {
				
				FileVO fileVO = new FileVO();
				fileVO.setFileMasterId(userVO.getFileMasterId());
				fileVO = fileService.findByFileMasterId(fileVO);
				
				model.addAttribute("userVO", userVO);
				session.setAttribute("profileImage", fileVO);
				
				if (!"admin".equals(userVO.getAuthority())) {
					return "admin/settings/form_prototype";
				}
			}
			
			//List<UserVO> userList = userService.selectUserList();
			
			// JPA 테스트
			List<UserVO> userList = userService.findAll();
			
			model.addAttribute("userList", userList);

//			List<CodeVO> codeClassList = codeService.selectCodeClassList();
//			
//			for (CodeVO codeClass : codeClassList) {
//				List<CodeVO> codeItemsList = codeService.selectCodeItemsList(codeClass);
//				codeClass.setCodeItems(codeItemsList);
//			}
	//	
//			model.addAttribute("codeClassList", codeClassList);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
