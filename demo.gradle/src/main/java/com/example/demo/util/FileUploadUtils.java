package com.example.demo.util;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.FileVO;

@Component("fileUploadUtils")
public class FileUploadUtils {

	//.addResourceLocations("file:/DATA/video/"); //리눅스 root에서 시작하는 폴더 경로
	public static final String fileStorePath = "/home/ec2-user/apps";
    //public static final String fileStorePath = "file:///C:/upload/";
	
	public List<FileVO> uploadFiles(java.math.BigDecimal fileMasterId, List<MultipartFile> files) {
		List<FileVO> fileInfoList = new ArrayList<FileVO>();
		
		try {

			//System.out.println("==================fileStorePath: " + fileStorePath);
			int idx = 1;
			for (MultipartFile file : files) {
				
				//System.out.println("==================file:" + file.toString());
				
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
	            fileVO.setFileSn(new BigDecimal(idx));
	            fileVO.setFileMasterId(fileMasterId);
	            fileVO.setOrgFileName(orgFileName);
	            fileVO.setFileName(fileName);
	            fileVO.setFilePath(filePath);
	            fileVO.setFileSize(new BigDecimal(file.getSize()));
	            fileInfoList.add(fileVO);
	            
	            idx++;
			}
			
        } catch(Exception e) {
            e.printStackTrace();
        }
		return fileInfoList;
	}

}

