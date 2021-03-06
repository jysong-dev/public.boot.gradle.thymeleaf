package com.example.demo.contoller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.FileVO;
import com.example.demo.domain.PrototypeMasterVO;
import com.example.demo.domain.UserVO;
import com.example.demo.service.FileService;
import com.example.demo.service.PrototypeMasterService;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	PrototypeMasterService prototypeMasterService;
	
	@Autowired
	FileService fileService;

    @PostMapping("/login")
    public String login(UserVO userVO, HttpSession session) {

    	try {
    		UserVO userInfo = userService.findByUserIdAndPassword(userVO);
        	
            if(userInfo != null){
            	
            	/* 마지막 로그인 시점 갱신 */
            	userService.updateByUserKey(userInfo);
            	
				FileVO fileVO = new FileVO();
				fileVO.setFileMasterId(userInfo.getFileMasterId());
				fileVO = fileService.findByFileMasterId(fileVO);
				
				session.setAttribute("userInfo", userInfo);
				session.setAttribute("profileImage", fileVO);

                if ("admin".equals(userInfo.getAuthority())) {
                	return "redirect:/admin/index";	
                } else {
                	return "redirect:/admin/settings/form-prototype";
                }
                
            } else {
            	
            	return "redirect:/user/sign-up";
            }
    	} catch (Exception e) {
			e.printStackTrace();
			
			return "redirect:/admin/index";
		}

    }
    
    @GetMapping("/logout")
    public String login(HttpSession session) {
        session.invalidate();
        
        return "redirect:/user/sign-in";
    }
    
    @ResponseBody
    @PostMapping("/sign-up")
    public Map<String, Object> signUp(UserVO userVO) {
    	Map<String, Object> jsonObj = new HashMap<String, Object>();
    	
    	try {

    		Integer sameUserIdCnt = userService.countByUserId(userVO);
    		
    		if (sameUserIdCnt > 0) {
    			
    			jsonObj.put("success", false);
    			jsonObj.put("msg", "이미 사용중인 아이디입니다.");
    		} else {
    			
    			BigDecimal nextUserKey = userService.selectNextUserKey();
    			userVO.setUserKey(nextUserKey);
    			userVO.setAuthority("user");
    			userService.save(userVO);
    			
    			PrototypeMasterVO prototypeMasterVO = new PrototypeMasterVO();
    			prototypeMasterVO.setPrototypeVisiblilty("N");
    			prototypeMasterVO.setUserKey(nextUserKey);
    			prototypeMasterVO.setCreateDatetime(new Date());
    			prototypeMasterService.save(prototypeMasterVO);
    			
    			jsonObj.put("success", true);
    			jsonObj.put("msg", "회원가입되었습니다.");
    			jsonObj.put("redirectUrl", "/user/sign-in");
    		}

    	} catch (Exception e) {
			e.printStackTrace();
			
			jsonObj.put("success", false);
			jsonObj.put("msg", "처리 중 오류가 발생하였습니다. 관리자에게 문의하세요.");
//			jsonObj.put("redirectUrl", "/user/sign-up");
		}
    	
    	return jsonObj;
    }
    
	@GetMapping("/user/sign-in")
	public String userSignIn() {
		
		System.out.println("");
		
		return "user/sign-in";
	}
	
	@GetMapping("/user/sign-up")
	public String userSignUp() {
		
		return "user/sign-up";
	}
	
}
