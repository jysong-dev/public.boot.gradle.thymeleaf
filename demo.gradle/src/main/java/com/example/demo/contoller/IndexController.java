package com.example.demo.contoller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.example.demo.domain.FileMasterVO;
import com.example.demo.domain.FileVO;
import com.example.demo.service.FileMasterService;
import com.example.demo.service.FileService;
import com.example.demo.util.FileUploadUtils;

@Controller
public class IndexController {

	@Autowired
	FileService fileService;
	
	@Autowired
	FileMasterService fileMasterService;
	
	@Autowired
	FileUploadUtils fileUploadUtils;
	
	@GetMapping("/admin/index/form")
	public String indexForm(Model model) {
		model.addAttribute("menuId", "index");
		
		return "admin/index/form";
	}
	
	@PostMapping("/admin/index/save-background")
	public String saveBackground(MultipartHttpServletRequest request, Model model) {
		
		try {

			model.addAttribute("menuId", "index");

			List<MultipartFile> files = new ArrayList<MultipartFile>();
			MultipartFile file = (MultipartFile) request.getFile("background-image");
			files.add(file);
			
			//System.out.println("========================파일업로드==========================");
			FileMasterVO fileMasterVO = new FileMasterVO();
			java.math.BigDecimal fileMasterId = fileMasterService.save(fileMasterVO);
			List<FileVO> fileInfoList = fileUploadUtils.uploadFiles(fileMasterId, files);
			
			for (FileVO fileVO : fileInfoList) {
				fileService.save(fileVO);
			}
			
			// save prototype background			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/admin/index/form";
	}
}
