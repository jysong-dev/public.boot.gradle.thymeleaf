package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.UserVO;
import com.example.demo.mapper.UserMapper;

@Service
public class UserService {
	
	@Autowired
	public UserMapper userMapper;

	public UserVO selectUser(UserVO userVO) {
		
		return userMapper.selectUser(userVO);
	}

	public void updateUserLastLoginDatetime(UserVO userVO) {
		
		userMapper.updateUserLastLoginDatetime(userVO);
	}

	public void insertUser(UserVO userVO) {
		
		userMapper.insertUser(userVO);
	}

	public Integer selectSameUserIdCount(UserVO userVO) {
		
		return userMapper.selectSameUserIdCount(userVO);
	}
	

}
