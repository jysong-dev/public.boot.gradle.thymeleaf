package com.example.demo.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.CodeVO;
import com.example.demo.service.CodeService;

@Controller
public class CodeController {
	
	@Autowired CodeService codeService;
	
	@ResponseBody
	@GetMapping("/json/code-class/list")
	public Map<String, Object> jsonCodeClassList() {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<CodeVO> codeClassList = codeService.selectCodeClassList();
		
		result.put("data", codeClassList);

		return result;
	}
	
}
