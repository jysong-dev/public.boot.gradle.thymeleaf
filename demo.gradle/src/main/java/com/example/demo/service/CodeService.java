package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CodeVO;
import com.example.demo.mapper.CodeMapper;

@Service
public class CodeService {
	
	@Autowired
	public CodeMapper codeMapper;
	
	public List<CodeVO> selectCodeClassList() {
		
		return codeMapper.selectCodeClassList();
	}

	public List<CodeVO> selectCodeItemsList(CodeVO codeVO) {

		return codeMapper.selectCodeItemsList(codeVO);
	}
}
