package kr.or.ddit.exception;

public class OverLapIDException extends Exception {

	public OverLapIDException() {
		super("중복된 ID 입니다.");
	}
}
