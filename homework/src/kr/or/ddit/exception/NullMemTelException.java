package kr.or.ddit.exception;

public class NullMemTelException extends Exception {

	public NullMemTelException() {
		super("전화번호가 입력되지 않았습니다.");
	}
}
