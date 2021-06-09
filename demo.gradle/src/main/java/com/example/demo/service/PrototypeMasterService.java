package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.PrototypeMasterVO;
import com.example.demo.repository.PrototypeMasterRepository;

@Service
public class PrototypeMasterService {
	
	@Autowired
	public PrototypeMasterRepository prototypeMasterRepository;

	public PrototypeMasterVO findByUserKey(PrototypeMasterVO prototypeMasterVO) {
		return prototypeMasterRepository.findByUserKey(prototypeMasterVO.getUserKey());
	}

	public void save(PrototypeMasterVO prototypeMasterVO) {
		prototypeMasterRepository.save(prototypeMasterVO);
	}

}
