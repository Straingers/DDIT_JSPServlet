package com.spring.command;

import java.util.Date;

import com.spring.dto.MemberVO;

public class MemberRegistCommand {
	
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String picture;
	private String authority;
	private String[] phone;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String[] getPhone() {
		return phone;
	}
	public void setPhone(String[] phone) {
		this.phone = phone;
	}
	
	public MemberVO toMemberVO() {
		String phone = "";
		for (String data : this.phone) {
			phone += data;
		}
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPwd(pwd);
		member.setName(name);
		member.setEmail(email);
		member.setAuthority(authority);
		member.setPicture(picture);
		member.setPhone(phone);
		member.setRegDate(new Date());
		
		return member;
	}
}
