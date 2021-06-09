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
    	
    	UserVO userVO = new UserVO();
    	userVO.setUserId(userId);
    	UserVO userInfo = userService.findByUserId(userVO);
    	
    	PrototypeMasterVO prototypeMasterVO = new PrototypeMasterVO();
    	prototypeMasterVO.setUserKey(userInfo.getUserKey());
    	PrototypeMasterVO prototypeMasterInfo = prototypeMasterService.findByUserKey(prototypeMasterVO);
//    	
//    	if (!"favicon.ico".equals(userId)) {
//    		
//    		LOGGER.info("유저 아이디 : " + userId);
//    		if ( prototypeMasterInfo != null && "Y".equals(prototypeMasterInfo.getPrototypeVisiblilty()) ) {
//    	    	
//    			WidgetVO widgetVO = new WidgetVO();
//    			List<WidgetVO> widgetList = widgetService.findByPrototypeId(widgetVO);
//    			
//    			// 위젯 목록
//    	    	model.addAttribute("widgetList", widgetList);
//    			// 알림, 반응 목록
//    			//model.addAttribute(attributeValue);
//    			
//    			return "index";
//    		} else {
//    			 return "redirect:admin/index";
//    		}
//    	}
    	
    	model.addAttribute("userInfo", userInfo);
    	
        //return "redirect:admin/index";
        return "index";
    }
	
	@GetMapping("/{userId}/diary/list")
	public String diaryList(@PathVariable("userId") String userId) {
		
    	UserVO userVO = new UserVO();
    	userVO.setUserId(userId);
    	UserVO userInfo = userService.findByUserId(userVO);
		
		return "diary/list";
	}
	
	@GetMapping("/{userId}/diary/view")
	public String diaryView(@PathVariable("userId") String userId) {
		
		return "diary/view";
	}
	
	@GetMapping("/{userId}/profile/view")
	public String profileView(@PathVariable("userId") String userId) {
		
		return "profile/view";
	}
	
	@PostMapping("/prototype/setting/update")
	@ResponseBody
	public Map<String, Object> updatePrototypeSetting(PrototypeMasterVO prototypeMasterVO, HttpServletRequest req) {
		Map<String, Object> jsonObj = new HashMap<String, Object>();

		HttpSession session = req.getSession();
		UserVO sessionUserInfo = (UserVO)session.getAttribute("userInfo");

//		try {
//			
//			if ("Y".equals(prototypeMasterVO.getPrototypeVisiblilty())) {
//			
//				if (checkPrototypeIsAvailable(sessionUserInfo)) {
//					prototypeMasterService.update(prototypeMasterVO);
//					jsonObj.put("success", true);
//					jsonObj.put("msg", "이 프로토타입이 공개되었습니다.");
//				} else {
//					jsonObj.put("success", false);
//					jsonObj.put("msg", "미입력된 필수 정보가 있어 프로토타입을 공개할 수 없습니다.");
//				}
//			
//			} else {
//				prototypeMasterService.update(prototypeMasterVO);
//				jsonObj.put("success", true);
//				jsonObj.put("msg", "이 프로토타입이 비공개되었습니다.");
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			jsonObj.put("success", false);
//			jsonObj.put("msg", "미입력된 필수 정보가 있어 프로토타입을 공개할 수 없습니다.");
//		}


		return jsonObj;
	}

	public Boolean checkPrototypeIsAvailable (UserVO userVO) {
		Boolean isAvailable = false;
		
		//if (prototypeMasterInfo != null && prototypeBasicProfileInfo != null && prototypeProfileStatusInfo != null && prototypeJobStatusInfo != null && prototypeQuestProgressInfo != null) {
			isAvailable = true;
		//}
		
		return isAvailable;
	}
	
}
