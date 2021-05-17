package com.example.demo.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.UserVO;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/user/sign_in")
	public String userSignIn() {
		
		return "user/sign_in";
	}

    @PostMapping("/login")
    public String login(UserVO userVO, HttpSession session) {

    	UserVO userInfo = userService.selectUser(userVO);
    	
        if(userInfo != null){
        	
        	userService.updateUserLastLoginDatetime(userInfo);
        	
            session.setAttribute("userInfo", userInfo);

            return "redirect:/admin/index";
        } else {
        	
        	return "redirect:/user/sign_up";
        }
        
    }
	
}
