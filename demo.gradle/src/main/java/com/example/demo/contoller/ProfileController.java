package com.example.demo.contoller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.PrototypeMasterVO;
import com.example.demo.domain.UserVO;
import com.example.demo.service.PrototypeMasterService;
import com.example.demo.service.UserService;

@Controller
public class ProfileController {
	
	@Autowired
	PrototypeMasterService prototypeMasterService;
	
	@Autowired
	UserService userService;
	
	/*
	 * 사용자
	 */
	
	@GetMapping("/{userId}/profile/view")
	public String profileView(@PathVariable("userId") String userId, Model model) {
		
		addUserModelAttribute(userId, model);
		
		System.out.println("유저아이디:" + userId);
		
		return "profile/view";
	}
	
	/*
	 * 관리자
	 */
	
	@GetMapping("/admin/profile/form")
	public String profileForm(Model model) {
		model.addAttribute("menuId", "profile");

		return "admin/profile/form";
	}
	
	@PostMapping("/admin/prototype/update-setting")
	@ResponseBody
	public Map<String, Object> updatePrototypeSetting(PrototypeMasterVO prototypeMasterVO, HttpServletRequest req) {
		Map<String, Object> jsonObj = new HashMap<String, Object>();

		HttpSession session = req.getSession();
		UserVO sessionUserInfo = (UserVO)session.getAttribute("userInfo");

//		try {
//			
//			if ("Y".equals(prototypeMasterVO.getPrototypeVisiblilty())) {
//			
//				if (checkPrototypeIsAvailable(sessionUserInfo)) {
//					prototypeMasterService.update(prototypeMasterVO);
//					jsonObj.put("success", true);
//					jsonObj.put("msg", "이 프로토타입이 공개되었습니다.");
//				} else {
//					jsonObj.put("success", false);
//					jsonObj.put("msg", "미입력된 필수 정보가 있어 프로토타입을 공개할 수 없습니다.");
//				}
//			
//			} else {
//				prototypeMasterService.update(prototypeMasterVO);
//				jsonObj.put("success", true);
//				jsonObj.put("msg", "이 프로토타입이 비공개되었습니다.");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			jsonObj.put("success", false);
//			jsonObj.put("msg", "미입력된 필수 정보가 있어 프로토타입을 공개할 수 없습니다.");
//		}

		return jsonObj;
	}

	@PostMapping("/admin/prototype/save-profile-image")
	public String saveProfileImage(Model model) {
		model.addAttribute("menuId", "profile");
		
		return "admin/profile/form";
	}
	
	@PostMapping("/admin/prototype/save-basic-profile")
	public String saveBasicProfile(Model model) {
		model.addAttribute("menuId", "profile");
		
		return "admin/profile/form";
	}
	
	@PostMapping("/admin/prototype/save-profile-status")
	public String saveProfileStatus(Model model) {
		model.addAttribute("menuId", "profile");
		
		return "admin/profile/form";
	}
	
	@PostMapping("/admin/prototype/save-job-status")
	public String saveProfileJobStatus(Model model) {
		model.addAttribute("menuId", "profile");
		
		return "admin/profile/form";
	}
	
	@PostMapping("/admin/profile/save-quest-progress")
	public String saveProfileQuestProgress(Model model) {
		model.addAttribute("menuId", "profile");
		
		return "admin/profile/form";
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
