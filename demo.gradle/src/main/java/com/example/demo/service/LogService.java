package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.LogVO;
import com.example.demo.repository.LogRepository;
import com.example.demo.repository.LogRepositorySupport;

@Service
public class LogService {

	@Autowired
	LogRepository logRepository;
	
	@Autowired
	LogRepositorySupport logRepositorySupport;

	public void save(LogVO logVO) {
		logRepository.save(logVO);
	}
	
	public List<LogVO> findByLogSeCode(LogVO logVO) {
		return logRepositorySupport.findByLogSeCode(logVO.getLogSeCode());
	}
	
}
