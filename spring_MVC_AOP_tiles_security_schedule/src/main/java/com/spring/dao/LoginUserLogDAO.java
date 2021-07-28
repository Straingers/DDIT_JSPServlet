package com.spring.dao;

import java.sql.SQLException;

import com.spring.dto.LoginUserLogVO;

public interface LoginUserLogDAO {
	
	void insertLoginUserLog(LoginUserLogVO logVO) throws SQLException;
	
	void deleteLoginUserLog() throws SQLException;
	
}
