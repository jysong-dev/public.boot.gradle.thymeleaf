package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.UserVO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserMapper userMapper;
	
	@Autowired
	public UserRepository userRepository;

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

	public List<UserVO> selectUserList() {
		
		return userMapper.selectUserList();
	}
	
	/** jpa test **/
	public List<UserVO> findAll() {
		List<UserVO> users = new ArrayList<>();
		userRepository.findAll().forEach(e -> users.add(e));
		return users;
	}

	public UserVO findByUserIdAndPassword(UserVO userVO) {
		return userRepository.findByUserIdAndPassword(userVO.getUserId(), userVO.getPassword());
	}

}
