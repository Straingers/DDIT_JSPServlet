package com.servlet.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.servlet.dto.MemberVO;

public class TestMyMemberService {

	private MyMemberServiceImpl service;
	
	@Before
	public void init() {
		service = new MyMemberServiceImpl();
		service.setMyMemberDAO(new MockMyMemberDAO());
	}
	
	@Test
	public void testGetAllMember() throws Exception {
		List<MemberVO> memberList = service.getAllMember();
		Assert.assertEquals(1, memberList.size());
		Assert.assertEquals("테스트", memberList.get(0).getMemName());
	}
	
	@Test
	public void testGetMember() throws Exception {
		MemberVO member = service.getMember("test01");
		Assert.assertEquals("테스트", member.getMemName());
	}
	
	@Test
	public void testMemberInsert() throws Exception {
		MemberVO member = new MemberVO();
		member.setMemId("test");
		int cnt = service.memberInsert(member);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testMemberUpdate() throws Exception {
		MemberVO member = new MemberVO();
		member.setMemId("test");
		int cnt = service.memberUpdate(member);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testMemberDelete() throws Exception {
		int cnt = service.memberDelete("test");
		Assert.assertEquals(1, cnt);
	}
}
