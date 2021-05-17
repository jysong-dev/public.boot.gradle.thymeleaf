package com.example.demo.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.UserVO;

@Controller
public class UserController {

	private final UserService userService;

    @GetMapping("/login")
    public String login() {
    	return "/user/sign_in";
    }

    @PostMapping("/login")
    public String login(UserVO userVO, HttpSession session) {

    	UserVO userInfo = userService.login(userVO);
    	
        if(userInfo != null){
        	
            session.setAttribute("userId", userInfo.getUserId());
            session.setAttribute("userKey", userInfo.getUserKey());
            session.setAttribute("authority", "");

            return "redirect:/admin/index";
        } else {
        	
        	return "redirect:/user/sign_up";
        }
        
    }
	
}
