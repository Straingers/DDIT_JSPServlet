package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.dto.MenuVO;

public class MenuDAOImpl implements MenuDAO {
	
	@Override
	public List<MenuVO> selectMainMenu(SqlSession session) throws SQLException {
		return session.selectList("Menu-Mapper.selectMainMenu");
	}

	@Override
	public List<MenuVO> selectSubMenu(SqlSession session, String mCode) throws SQLException {
		return session.selectList("Menu-Mapper.selectSubMenu", mCode);
	}

	@Override
	public MenuVO selectMenuByMcode(SqlSession session, String mCode) throws SQLException {
		return session.selectOne("Menu-Mapper.selectMenuByMcode", mCode);
	}

	@Override
	public MenuVO selectMenuByMname(SqlSession session, String mName) throws SQLException {
		return session.selectOne("Menu-Mapper.selectMenuByMname", mName);
	}

}
