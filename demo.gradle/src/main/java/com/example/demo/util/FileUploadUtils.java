package com.example.demo.util;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.FileMasterVO;
import com.example.demo.domain.FileVO;
import com.example.demo.service.FileMasterService;
import com.example.demo.service.FileService;

public class FileUploadUtils {

	@Autowired
	FileService fileService;
	
	@Autowired
	FileMasterService fileMasterService;
	
	final String fileStorePath = "C:" + File.separator ;
	
	public java.math.BigDecimal uploadFiles(List<MultipartFile> files) {
		
		try {
			FileMasterVO fileMasterVO = new FileMasterVO();
			java.math.BigDecimal fileMasterId = fileMasterService.save(fileMasterVO);
			
			for (MultipartFile file : files) {
				
				String orgFileName = file.getOriginalFilename();
				String extension = orgFileName.substring(orgFileName.lastIndexOf("."), orgFileName.length());
				UUID uuid = UUID.randomUUID();
				String fileName = uuid.toString() + extension;

	            if (!new File(fileStorePath).exists()) {
	            	new File(fileStorePath).mkdir();
	            }
	            
	            String filePath = fileStorePath + fileName;
	            file.transferTo(new File(filePath));

	            FileVO fileVO = new FileVO();
	            fileVO.setFileMasterId(fileMasterId);
	            fileVO.setOrgFileName(orgFileName);
	            fileVO.setFileName(fileName);
	            fileVO.setFilePath(filePath);
	            fileService.save(fileVO);

			}
			
			return fileMasterId;

        } catch(Exception e) {
            e.printStackTrace();
            return new BigDecimal(0);
        }
	}

}
