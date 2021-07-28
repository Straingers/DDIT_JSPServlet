package kr.or.ddit.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.dto.MemberVO;

public class TestMemberService {

	private MemberServiceImpl service;
	
	@Before
	public void init() {
		service = new MemberServiceImpl();
		service.setMemberDAO(new MockMemberDAO());
	}
	
	@Test
	public void testGetAllMember() throws Exception {
		List<MemberVO> memberList = service.getAllMember();
		Assert.assertEquals(1, memberList.size());
		Assert.assertEquals("테스트", memberList.get(0).getName());
	}
	
	@Test
	public void testGetMember() throws Exception {
		MemberVO member = service.getMember("test01");
		Assert.assertEquals("테스트", member.getName());
	}
	
	@Test
	public void testMemberInsert() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("test");
		int cnt = service.memberInsert(member);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testMemberUpdate() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("test");
		int cnt = service.memberUpdate(member);
		Assert.assertEquals(1, cnt);
	}
	
	@Test
	public void testMemberDelete() throws Exception {
		int cnt = service.memberDelete("test");
		Assert.assertEquals(1, cnt);
	}
}
