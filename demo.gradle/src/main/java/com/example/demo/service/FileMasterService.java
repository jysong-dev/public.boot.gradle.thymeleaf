package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.FileMasterVO;
import com.example.demo.mapper.FileMasterMapper;
import com.example.demo.repository.FileMasterRepository;

@Service
public class FileMasterService {
	
	@Autowired
	FileMasterRepository fileMasterRepository;
	
	@Autowired
	FileMasterMapper fileMasterMapper;

	public BigDecimal save(FileMasterVO fileMasterVO) {
		
		try {
			java.math.BigDecimal nextFileMasterId = fileMasterMapper.selectNextFileMasterId();
			
			fileMasterVO.setFileMasterId(nextFileMasterId);
			fileMasterRepository.save(fileMasterVO);
			
			return nextFileMasterId;
		}catch (Exception e) {
			e.printStackTrace();
		}

		return new BigDecimal(0);
	}

}
