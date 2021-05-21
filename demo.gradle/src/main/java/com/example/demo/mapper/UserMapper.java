package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.UserVO;

@Repository
@Mapper
public interface UserMapper {
	
	public UserVO selectUser(UserVO userVO);

	public void updateUserLastLoginDatetime(UserVO userVO);

	public void insertUser(UserVO userVO);

	public Integer selectSameUserIdCount(UserVO userVO);

	public List<UserVO> selectUserList();

}
