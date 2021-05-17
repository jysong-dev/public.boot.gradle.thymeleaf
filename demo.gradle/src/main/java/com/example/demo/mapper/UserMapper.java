package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.UserVO;

@Repository
@Mapper
public interface UserMapper {
	
	public UserVO selectUser(UserVO userVO);

	public void updateUserLastLoginDatetime(UserVO userVO);

}
