package com.example.demo.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.UserVO;

@Repository
@Mapper
public interface UserMapper {

	public BigDecimal selectNextUserKey();
	
	/**
	 * jpa 추가로 삭제
	 */
	
	//public UserVO selectUser(UserVO userVO);

	//public Integer selectSameUserIdCount(UserVO userVO);

	//public List<UserVO> selectUserList();

	//public void updateUserLastLoginDatetime(UserVO userVO);

	//public void insertUser(UserVO userVO);

}
