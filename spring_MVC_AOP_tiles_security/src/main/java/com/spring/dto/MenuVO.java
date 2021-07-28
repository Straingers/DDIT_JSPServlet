package com.spring.dto;

public class MenuVO {
	private String mCode;  // 메뉴 코드
	private String mName;  // 메뉴 이름
 	private String mUrl;   // 메뉴 url
	private String mIcon;  // 메뉴 아이콘
	private String jText;  // javaScript
	private String upCode; // 상위메뉴 코드
	private int mLevel;    // 메뉴 레벨
	
	public String getmCode() {
		return mCode;
	}
	public void setmCode(String mCode) {
		this.mCode = mCode;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmUrl() {
		return mUrl;
	}
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
	public String getmIcon() {
		return mIcon;
	}
	public void setmIcon(String mIcon) {
		this.mIcon = mIcon;
	}
	public String getjText() {
		return jText;
	}
	public void setjText(String jText) {
		this.jText = jText;
	}
	public String getUpCode() {
		return upCode;
	}
	public void setUpCode(String upCode) {
		this.upCode = upCode;
	}
	public int getmLevel() {
		return mLevel;
	}
	public void setmLevel(int mLevel) {
		this.mLevel = mLevel;
	}
}
