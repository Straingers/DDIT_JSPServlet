package kr.or.ddit.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.command.PageMaker;
import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dao.MemberDAO;
import kr.or.ddit.dto.MemberVO;
import kr.or.ddit.exception.NotFoundMemberException;
import kr.or.ddit.exception.NullMemIDException;
import kr.or.ddit.exception.NullMemNameException;
import kr.or.ddit.exception.NullMemPwException;
import kr.or.ddit.exception.NullMemTelException;
import kr.or.ddit.exception.OverLapIDException;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memberDAO; //= new MemberDAOImpl();
	private SqlSessionFactory sqlSessionFactory; //= new OracleMyBatisSessionFactory();
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<MemberVO> getAllMember() throws NotFoundMemberException, SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			List<MemberVO> memberList = memberDAO.selectAllMember(session);
			return memberList;
		} finally {
			session.close();
		}
	}
	@Override
	public Map<String, Object> getAllMember(SearchCriteria cri) throws NotFoundMemberException, SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		Map<String, Object> dataMap = new HashMap<>();
		try {
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(memberDAO.selectAllMemberCount(session, cri));
			dataMap.put("pageMaker", pageMaker);
			
			List<MemberVO> memberList = memberDAO.selectAllMember(session, cri);
			dataMap.put("memberList", memberList);
			
			return dataMap;
		} finally {
			session.close();
		}

	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			MemberVO mv = memberDAO.selectMemberById(session, id);
			return mv;
		} finally {
			session.close();
		}
	}

	@Override
	public int memberInsert(MemberVO mv)
			throws NullMemIDException, OverLapIDException, NullMemPwException, NullMemNameException, NullMemTelException, SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		if("".equals(mv.getId())) {
			throw new NullMemIDException();
		} else if(memberDAO.overlapMemberIdCheck(session, mv.getId()) > 0) {
			throw new OverLapIDException();
		}else if("".equals(mv.getPwd())) {
			throw new NullMemPwException();
		} else if("".equals(mv.getName())) {
			throw new NullMemNameException();
		} else if("".equals(mv.getPhone())) {
			throw new NullMemTelException();
		}
		int cnt = 0;
		try {
			cnt = memberDAO.createMember(session, mv);
			return cnt;
		} finally {
			session.close();
		}
	}

	@Override
	public int memberUpdate(MemberVO mv) throws NullMemPwException, NullMemTelException, SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		if("".equals(mv.getPwd())) {
			throw new NullMemPwException();
		} else if("".equals(mv.getPhone())) {
			throw new NullMemTelException();
		}
		int cnt = 0;
		try {
			cnt = memberDAO.updateMember(session, mv);
			return cnt;
		} finally {
			session.close();
		}
	}

	@Override
	public int memberDelete(String id) throws SQLException {
		SqlSession session = sqlSessionFactory.openSession();
		int cnt = 0;
		try {
			cnt = memberDAO.deleteMember(session, id);
			return cnt;
		}finally {
			session.close();
		}
	}
}
