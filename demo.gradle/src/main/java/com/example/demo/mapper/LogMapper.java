package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.LogVO;

@Repository
@Mapper
public interface LogMapper {

	void insertLog(LogVO logVO);
	
	
}
