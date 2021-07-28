package kr.or.ddit.exception;

public class NotFoundMemberException extends Exception{
	public NotFoundMemberException() {
		super("등록된 회원이 없습니다.");
	}
}
