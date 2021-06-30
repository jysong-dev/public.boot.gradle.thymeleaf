package com.example.demo.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.UserVO;

@Repository
@Mapper
public interface FileMasterMapper {

	public BigDecimal selectNextFileMasterId();

}
