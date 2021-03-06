package com.example.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	public void updateByUserKey(UserVO userVO) {
		
		userRepository.save(userVO);
		
//		Optional<UserVO> e = userRepository.findByUserKey(userVO.getUserKey());
//
//		if (e.isPresent()) {
//			e.get().setUsername(e.get().getUsername());
//			e.get().setPassword(e.get().getPassword());
//			e.get().setAuthority(e.get().getAuthority());
//			e.get().setFileMasterId(userVO.getFileMasterId());
//			e.get().setUserBio(userVO.getUserBio());
//			e.get().setLastLoginDatetime(new Date());
//			userRepository.save(userVO);
//		}
	}

	public void save(UserVO userVO) {
		
		userRepository.save(userVO);
	}

	public List<UserVO> findAll() {
		
//		List<UserVO> users = new ArrayList<>();
//		userRepository.findAll().forEach(e -> users.add(e));
		return userRepository.findAll(Sort.by(Sort.Direction.DESC, "registDatetime"));
	}

	public UserVO findByUserIdAndPassword(UserVO userVO) {
		
		return userRepository.findByUserIdAndPassword(userVO.getUserId(), userVO.getPassword());
	}

	public Integer countByUserId(UserVO userVO) {
		
		return userRepository.countByUserId(userVO.getUserId());
	}

	public UserVO findByUserId(UserVO userVO) {

		return userRepository.findByUserId(userVO.getUserId());
	}

	public BigDecimal selectNextUserKey() {

		return userMapper.selectNextUserKey();
	}

}
