/*필요한 서비스 메서드 창고*/
package com.js.file.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.js.mybatis.config.MyBatisConfig;
import com.js.user.domain.UserVO;

public class BoardFileDAO {
	public SqlSession sqlSession;
	
	public BoardFileDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

}






















