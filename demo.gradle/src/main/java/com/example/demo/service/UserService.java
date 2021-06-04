package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.domain.UserVO;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;

	public void updateByUserKey(UserVO userVO) {
		Optional<UserVO> e = userRepository.findByUserKey(userVO.getUserKey());

		if (e.isPresent()) {
			e.get().setUsername(userVO.getUsername());
			e.get().setPassword(userVO.getPassword());
			e.get().setAuthority(userVO.getAuthority());
			e.get().setLastLoginDatetime(userVO.getLastLoginDatetime());
			userRepository.save(userVO);
		}
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

}
