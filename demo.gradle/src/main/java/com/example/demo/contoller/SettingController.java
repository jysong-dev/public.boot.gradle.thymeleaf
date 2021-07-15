package com.example.demo.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.domain.FileMasterVO;
import com.example.demo.domain.FileVO;
import com.example.demo.domain.UserVO;
import com.example.demo.service.FileMasterService;
import com.example.demo.service.FileService;
import com.example.demo.service.UserService;
import com.example.demo.util.FileUploadUtils;

@Controller
public class SettingController {
	
	//@Autowired
	//PrototypeMasterService prototypeMasterService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	FileService fileService;
	
	@Autowired
	FileUploadUtils fileUploadUtils;
	
	@Autowired
	FileMasterService fileMasterService;

	@GetMapping("/admin/settings/form-account")
	public String settingForm(HttpSession session, Model model) {
		
		try {
			UserVO userVO = (UserVO) session.getAttribute("userInfo");
			if (userVO == null) {
				return "redirect:/user/sign_in";
			} else {
				FileVO fileVO = new FileVO();
				fileVO.setFileMasterId(userVO.getFileMasterId());
				fileVO = fileService.findByFileMasterId(fileVO);
				
				model.addAttribute("userVO", userVO);
				model.addAttribute("fileVO", fileVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "admin/settings/form_account";
	}
	
	@PostMapping("/admin/settings/save-account-info")
	public String saveAccountInfo(UserVO userVO, MultipartHttpServletRequest request, HttpSession session, Model model) {
		
		try {
			
			UserVO sessionUserInfo = (UserVO) session.getAttribute("userInfo");
			if (userVO == null) {
				
				return "redirect:/user/sign_in";
			} else {
				
				userVO.setUserId(sessionUserInfo.getUserId());
				userVO.setPassword(sessionUserInfo.getPassword());
				userVO.setAuthority(sessionUserInfo.getAuthority());
				userVO.setLastLoginDatetime(sessionUserInfo.getLastLoginDatetime());
				
				MultipartFile file = (MultipartFile) request.getFile("profile-image");
				
				if (file != null) {
					List<MultipartFile> files = new ArrayList<MultipartFile>();
					files.add(file);
					
					FileMasterVO fileMasterVO = new FileMasterVO();
					java.math.BigDecimal fileMasterId = fileMasterService.selectNextFileMasterId();
					List<FileVO> fileInfoList = fileUploadUtils.uploadFiles(fileMasterId, files);
					
					if (fileInfoList.size() > 0) {
						fileMasterVO.setFileMasterId(fileMasterId);
						fileMasterService.save(fileMasterVO);
						for (FileVO fileVO : fileInfoList) {
							fileService.save(fileVO);
						}
						userVO.setFileMasterId(fileMasterId);
					}
				} else {
					userVO.setFileMasterId(sessionUserInfo.getFileMasterId());
				}

				userService.updateByUserKey(userVO);
				UserVO updatedUserInfo = userService.findByUserId(userVO);

				session.setAttribute("userInfo", updatedUserInfo);
				
				FileVO fileVO = new FileVO();
				fileVO.setFileMasterId(updatedUserInfo.getFileMasterId());
				fileVO = fileService.findByFileMasterId(fileVO);

				session.setAttribute("profileImage", fileVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/settings/form_account";
	}
	
	
	@GetMapping("/admin/settings/form_prototype")
	public String settingFormPrototype(Model model) {
		model.addAttribute("menuId", "settings");
	
		return "admin/settings/form_prototype";
	}
	
}