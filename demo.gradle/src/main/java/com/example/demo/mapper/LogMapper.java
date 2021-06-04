package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.LogVO;

@Repository
@Mapper
public interface LogMapper {

	//void insertLog(LogVO logVO);

	List<LogVO> countByCreatePnttm(LogVO logVO);

	List<LogVO> countByBrowser(LogVO logVO);
	
}
