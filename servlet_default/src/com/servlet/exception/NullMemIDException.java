package com.servlet.exception;

public class NullMemIDException extends Exception {

	public NullMemIDException() {
		super("ID가 입력되지 않았습니다.");
	}
}
