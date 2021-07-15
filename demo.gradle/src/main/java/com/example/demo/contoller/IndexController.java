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
import com.example.demo.domain.PrototypeBackgroundVO;
import com.example.demo.domain.PrototypeMasterVO;
import com.example.demo.domain.UserVO;
import com.example.demo.service.FileMasterService;
import com.example.demo.service.FileService;
import com.example.demo.service.PrototypeBackgroundService;
import com.example.demo.service.PrototypeMasterService;
import com.example.demo.util.FileUploadUtils;

@Controller
public class IndexController {

	@Autowired
	FileService fileService;
	
	@Autowired
	FileMasterService fileMasterService;
	
	@Autowired
	PrototypeMasterService prototypeMasterService;
	
	@Autowired
	PrototypeBackgroundService prototypeBackgroundService;
	
	@Autowired
	FileUploadUtils fileUploadUtils;
	
	@GetMapping("/admin/index/form")
	public String indexForm(Model model, HttpSession session) {
		try {
			model.addAttribute("menuId", "index");
			UserVO userVO = (UserVO) session.getAttribute("userInfo");
			if (userVO == null) {
				
				return "redirect:/user/sign_in";
			} else {
				PrototypeMasterVO prototypeMasterVO = new PrototypeMasterVO();
				prototypeMasterVO.setUserKey(userVO.getUserKey());
				prototypeMasterVO = prototypeMasterService.findByUserKey(prototypeMasterVO);
				
				PrototypeBackgroundVO prototypeBackgroundVO =  new PrototypeBackgroundVO();
				prototypeBackgroundVO.setPrototypeId(prototypeMasterVO.getPrototypeId());
				prototypeBackgroundVO = prototypeBackgroundService.findByPrototypeId(prototypeBackgroundVO);
				
				FileVO fileVO = new FileVO();
				fileVO.setFileMasterId(prototypeBackgroundVO.getFileMasterId());
				fileVO = fileService.findByFileMasterId(fileVO);
				
				model.addAttribute("prototypeMasterVO", prototypeMasterVO);				
				model.addAttribute("prototypeBackgroundVO", prototypeBackgroundVO);
				model.addAttribute("fileVO", fileVO);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "admin/index/form";
	}
	
	@PostMapping("/admin/index/save-background")
	public String saveBackground(MultipartHttpServletRequest request, Model model, PrototypeBackgroundVO prototypeBackgroundVO) {
		
		try {
			model.addAttribute("menuId", "index");

			List<MultipartFile> files = new ArrayList<MultipartFile>();
			MultipartFile file = (MultipartFile) request.getFile("background-image");
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
			}

			prototypeBackgroundVO.setFileMasterId(fileMasterId);
			
			if (prototypeBackgroundVO.getBackgroundId() != null) {
				prototypeBackgroundService.updateByPrototypeId(prototypeBackgroundVO);
			} else {
				prototypeBackgroundService.save(prototypeBackgroundVO);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/index/form";
	}
}
