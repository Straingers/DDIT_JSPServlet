package com.spring.command;

import com.spring.dto.ReplyVO;

public class ReplyModifyCommand extends ReplyRegistCommand {
	
	private int rno;
	
	public int getRno() {
		return rno;
	}
	
	public void setRno(int rno) {
		this.rno = rno;
	}
	
	public ReplyVO toReplyVO() {
		ReplyVO reply = super.toReplyVO();
		reply.setRno(rno);
		
		return reply;
	}




	
}
