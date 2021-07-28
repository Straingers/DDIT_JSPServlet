package com.servlet.exception;

public class NullMemNameException extends Exception {

	public NullMemNameException() {
		super("비밀번호가 입력되지 않았습니다.");
	}
}
