package com.example.demo.contoller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.UserVO;
import com.example.demo.service.UserService;

import ch.qos.logback.classic.Logger;

@Controller
public class UserController {

	@Autowired
	UserService userService;

    @PostMapping("/login")
    public String login(UserVO userVO, HttpSession session) {

    	try {
    		UserVO userInfo = userService.selectUser(userVO);
        	
            if(userInfo != null){
            	
            	userService.updateUserLastLoginDatetime(userInfo);
            	
                session.setAttribute("userInfo", userInfo);

                return "redirect:/admin/index";
            } else {
            	
            	return "redirect:/user/sign_up";
            }
    	} catch (Exception e) {
			e.printStackTrace();
			
			return "redirect:/index";
		}

    }
    
    @ResponseBody
    @PostMapping("/sign_up")
    public Map<String, Object> signUp(UserVO userVO) {
    	Map<String, Object> jsonObj = new HashMap<String, Object>();
    	
    	try {
    		
    		Integer sameUserIdCnt = userService.selectSameUserIdCount(userVO);
    		
    		if (sameUserIdCnt > 0) {
    			
    			jsonObj.put("success", false);
    			jsonObj.put("msg", "이미 사용중인 아이디입니다.");
    			
    			return jsonObj;
    		} else {
    			userService.insertUser(userVO);	
    			
    			jsonObj.put("success", true);
    			jsonObj.put("msg", "회원가입되었습니다.");
    			jsonObj.put("redirectUrl", "/user/sign_in");
    			
    			return jsonObj;
    		}

    	} catch (Exception e) {
			e.printStackTrace();
			
			jsonObj.put("success", false);
			jsonObj.put("msg", "처리 중 오류가 발생하였습니다. 관리자에게 문의하세요.");
//			jsonObj.put("redirectUrl", "/user/sign_up");
		}

    }
    
	@GetMapping("/user/sign_in")
	public String userSignIn() {
		
		return "user/sign_in";
	}
	
	@GetMapping("/user/sign_up")
	public String userSignUp() {
		
		return "user/sign_up";
	}
	
}
