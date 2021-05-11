package com.example.demo.domain;

import java.util.List;

public class CodeVO {
	
	/**
	 * code_class_tb
	 */
	private String codeClassId;
	private String codeClassNameEng;
	private String codeClassNameKr;
	private String codeClassDesc;

	/**
	 * code_tb
	 */
	private String codeVal;
	private String codeNmEn;
	private String codeNmKo;
	private String codeDesc;
	
	private List<CodeVO> codeItems;
	
	public String getCodeClassId() {
		return codeClassId;
	}
	public void setCodeClassId(String codeClassId) {
		this.codeClassId = codeClassId;
	}
	public String getCodeClassNameEng() {
		return codeClassNameEng;
	}
	public void setCodeClassNameEng(String codeClassNameEng) {
		this.codeClassNameEng = codeClassNameEng;
	}
	public String getCodeClassNameKr() {
		return codeClassNameKr;
	}
	public void setCodeClassNameKr(String codeClassNameKr) {
		this.codeClassNameKr = codeClassNameKr;
	}
	public String getCodeClassDesc() {
		return codeClassDesc;
	}
	public void setCodeClassDesc(String codeClassDesc) {
		this.codeClassDesc = codeClassDesc;
	}
	public String getCodeVal() {
		return codeVal;
	}
	public void setCodeVal(String codeVal) {
		this.codeVal = codeVal;
	}
	public String getCodeNmEn() {
		return codeNmEn;
	}
	public void setCodeNmEn(String codeNmEn) {
		this.codeNmEn = codeNmEn;
	}
	public String getCodeNmKo() {
		return codeNmKo;
	}
	public void setCodeNmKo(String codeNmKo) {
		this.codeNmKo = codeNmKo;
	}
	public String getCodeDesc() {
		return codeDesc;
	}
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	public List<CodeVO> getCodeItems() {
		return codeItems;
	}
	public void setCodeItems(List<CodeVO> codeItems) {
		this.codeItems = codeItems;
	}
	
}
