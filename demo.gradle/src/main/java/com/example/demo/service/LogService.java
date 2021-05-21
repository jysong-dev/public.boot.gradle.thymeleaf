package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.LogVO;
import com.example.demo.mapper.LogMapper;

@Service
public class LogService {
	
	@Autowired
	LogMapper logMapper;

	public void insertLog(LogVO logVO) {
		logMapper.insertLog(logVO);
	}
}
