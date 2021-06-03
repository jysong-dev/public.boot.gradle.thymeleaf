package com.example.demo.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.LogVO;
import com.example.demo.service.LogService;

@Controller
public class LogController {
	
	@Autowired
	LogService logService;
	
	@RequestMapping("/log/header")
	@ResponseBody
	public Map<String, Object> getHeaderMakerVisitLogs() {
		Map<String, Object> resultObj = new HashMap<String, Object>();
		
		try {
			LogVO logVO = new LogVO();
			logVO.setLogSeCode("HEADER");
			List<LogVO> headerLogs = logService.findByLogSeCode(logVO);
			System.out.println("headerLogs:" + headerLogs.toString());
			
			resultObj.put("success", true);
			resultObj.put("data", headerLogs);
			
		} catch (Exception e) {
			e.printStackTrace();
			resultObj.put("success", false);
			resultObj.put("msg", "조회에 실패하였습니다.");
		}
		
		return resultObj;
	}

}
