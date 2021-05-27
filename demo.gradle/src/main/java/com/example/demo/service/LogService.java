package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.LogVO;
import com.example.demo.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	LogRepository logRepository;

	public void save(LogVO logVO) {
		logRepository.save(logVO);
	}
}
