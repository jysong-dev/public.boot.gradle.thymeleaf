package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.domain.FileVO;
import com.example.demo.repository.FileRepository;

@Service
public class FileService {
	
	@Autowired
	FileRepository fileRepository;

	public void save(FileVO fileVO) {
		fileRepository.save(fileVO);
	}

	public FileVO findByFileMasterId(FileVO fileVO) {
		return fileRepository.findByFileMasterId(fileVO.getFileMasterId());
	}

}
