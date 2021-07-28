package kr.or.ddit.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.command.SearchCriteria;
import kr.or.ddit.dto.ProdVO;

public class ProdDAOImpl implements ProdDAO {

	@Override
	public List<ProdVO> selectSearchProdList(SqlSession session, SearchCriteria cri) throws SQLException {
		
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<ProdVO> prodList=
				session.selectList("Prod-Mapper.selectSearchProdList",cri,rowBounds);
		
		return prodList;
	}
	@Override
	public List<ProdVO> selectSearchProdListByCategory(SqlSession session, SearchCriteria cri) throws SQLException {
		
		int offset=cri.getStartRowNum();
		int limit=cri.getPerPageNum();		
		RowBounds rowBounds=new RowBounds(offset,limit);		
		
		List<ProdVO> prodList=
				session.selectList("Prod-Mapper.selectProdByCategory",cri,rowBounds);
		
		return prodList;
	}

	@Override
	public int selectSearchProdListCount(SqlSession session, SearchCriteria cri) throws SQLException {
		int count=session.selectOne("Prod-Mapper.selectSearchProdListCount",cri);
		return count;
	}
	
	@Override
	public int selectSearchProdListByCategoryCount(SqlSession session, SearchCriteria cri) throws SQLException {
		return session.selectOne("Prod-Mapper.selectSearchProdListByCategoryCount", cri);
	}

	@Override
	public ProdVO selectProdById(SqlSession session, String id) throws SQLException {
		ProdVO prod=session.selectOne("Prod-Mapper.selectProdById",id);
		return prod;
	}

	@Override
	public void increaseViewCount(SqlSession session, String id) throws SQLException {
		session.update("Prod-Mapper.increaseViewCount",id);
		
	}

	@Override
	public int selectProdSequenceNextValue(SqlSession session) throws SQLException {
		int seq_num=session.selectOne("Prod-Mapper.selectProdSequenceNextValue");
		return seq_num;
	}

	@Override
	public void insertProd(SqlSession session, ProdVO prod) throws SQLException {
		session.update("Prod-Mapper.insertProd",prod);
		
	}
	
	@Override
	public void updateProd(SqlSession session,ProdVO prod) throws SQLException {
		session.update("Prod-Mapper.updateProd",prod);
	}

	@Override
	public void deleteProd(SqlSession session,String id) throws SQLException {
		session.delete("Prod-Mapper.deleteProd",id);
	}
	@Override
	public void modifyProdQty(SqlSession session, ProdVO prod) throws SQLException {
		session.update("Prod-Mapper.modifyProdQty", prod);
	}

}











