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
		
		for (CodeVO codeClass : codeClassList) {
			List<CodeVO> codeItemsList = codeService.selectCodeItemsList(codeClass);
			codeClass.setCodeItems(codeItemsList);
		}

		result.put("list", codeClassList);

		return result;
	}
	
	@ResponseBody
	@GetMapping("/json/code-class/items")
	public Map<String, Object> jsonCodeItemsList(CodeVO codeVO) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		List<CodeVO> codeItemsList = codeService.selectCodeItemsList(codeVO);

		result.put("list", codeItemsList);

		return result;
	}
	
}
