package com.example.demo.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.LogVO;
import com.example.demo.service.LogService;

@Controller
public class HeaderMakerController {
	
	@Autowired
	LogService logService;

	@GetMapping("/hits")
	@ResponseBody
	public String hits(HttpServletRequest req) {
		try {
			HttpSession session = req.getSession();
			LogVO logVO= new LogVO();
			String agent = req.getHeader("user-agent");
			String referer = req.getHeader("referer");
			
			logVO.setSessionId(session.getId());
			logVO.setLogSeCode("HEADER");
			logVO.setUserAgent(agent);
			logVO.setReferer(referer);
			logVO.setRequesterIp(req.getRemoteAddr());
			
			logService.save(logVO);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "welcome!";
	}

}
