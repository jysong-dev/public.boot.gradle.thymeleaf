package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.CodeVO;

@Repository
@Mapper
public interface CodeMapper {

	public List<CodeVO> selectCodeClassList();

	public List<CodeVO> selectCodeItemsList(CodeVO codeVO);
	
}
