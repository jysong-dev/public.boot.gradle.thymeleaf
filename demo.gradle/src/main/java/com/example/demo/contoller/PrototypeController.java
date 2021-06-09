package com.example.demo.contoller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.SessionListener;
import com.example.demo.domain.PrototypeMasterVO;
import com.example.demo.domain.UserVO;
import com.example.demo.domain.WidgetVO;
import com.example.demo.service.PrototypeMasterService;
import com.example.demo.service.UserService;
import com.example.demo.service.WidgetService;

@Controller
public class PrototypeController {
	
	@Autowired
	PrototypeMasterService prototypeMasterService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	WidgetService widgetService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PrototypeController.class);
	
    @GetMapping("/{userId}")
    public String index(@PathVariable("userId") String userId, Model model){
  	
    	if (!"favicon.ico".equals(userId)) {
    	
    		addUserModelAttribute(userId, model);
	    	
//	    	if (!"favicon.ico".equals(userId)) {
//	    		
//	    		LOGGER.info("유저 아이디 : " + userId);
//	    		if ( prototypeMasterInfo != null && "Y".equals(prototypeMasterInfo.getPrototypeVisiblilty()) ) {
//	    	    	
//	    			WidgetVO widgetVO = new WidgetVO();
//	    			List<WidgetVO> widgetList = widgetService.findByPrototypeId(widgetVO);
//	    			
//	    			// 위젯 목록
//	    	    	model.addAttribute("widgetList", widgetList);
//	    			// 알림, 반응 목록
//	    			//model.addAttribute(attributeValue);
//	    			
//	    			return "index";
//	    		} else {
//	    			 return "redirect:admin/index";
//	    		}
//	    	}
    	
    	}
    	
        //return "redirect:admin/index";
        return "index";
    }

	public Boolean checkPrototypeIsAvailable (UserVO userVO) {
		Boolean isAvailable = false;
		
		//if (prototypeMasterInfo != null && prototypeBasicProfileInfo != null && prototypeProfileStatusInfo != null && prototypeJobStatusInfo != null && prototypeQuestProgressInfo != null) {
			isAvailable = true;
		//}
		
		return isAvailable;
	}
	
    public void addUserModelAttribute(String userId, Model model) {
    	UserVO userVO = new UserVO();
    	userVO.setUserId(userId);
    	UserVO userInfo = userService.findByUserId(userVO);
    	
    	PrototypeMasterVO prototypeMasterVO = new PrototypeMasterVO();
    	prototypeMasterVO.setUserKey(userInfo.getUserKey());
    	PrototypeMasterVO prototypeMasterInfo = prototypeMasterService.findByUserKey(prototypeMasterVO);
    	
    	model.addAttribute("userInfo", userInfo);
    }
	
}
