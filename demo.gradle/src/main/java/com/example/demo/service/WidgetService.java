package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.WidgetVO;
import com.example.demo.repository.WidgetRepository;

@Service
public class WidgetService {

	@Autowired
	WidgetRepository widgetRepository;

	public List<WidgetVO> findByPrototypeId(WidgetVO widgetVO) {

		return widgetRepository.findByPrototypeId(widgetVO.getPrototypeId());
	}
	
	
}
