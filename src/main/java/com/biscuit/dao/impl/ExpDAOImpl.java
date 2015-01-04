package com.biscuit.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.biscuit.dao.ExpDAO;
import com.biscuit.entity.ExpEntity;

@Repository("expDAO")
public class ExpDAOImpl extends SqlSessionDaoSupport implements ExpDAO {

	@Override
	public int insertExp(ExpEntity exp)
	{
		this.getSqlSession().insert("insertExp", exp);
		return exp.getId();
	}

	@Override
	public List<ExpEntity> getAllExps()
	{
		return this.getSqlSession().selectList("getAllExps");
	}
	
	@Override
	public ExpEntity getExpById(int id)
	{
		return this.getSqlSession().selectOne("getExpById",id);
	}
}
