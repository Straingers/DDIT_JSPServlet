package kr.or.ddit.exception;

public class NullMemPwException extends Exception {

	public NullMemPwException() {
		super("비밀번호가 입력되지 않았습니다.");
	}
}
