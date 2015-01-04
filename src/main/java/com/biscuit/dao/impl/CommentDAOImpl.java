package com.biscuit.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.biscuit.dao.CommentDAO;
import com.biscuit.entity.CommentEntity;

@Repository("commentDAO")
public class CommentDAOImpl extends SqlSessionDaoSupport implements CommentDAO {

	@Override
	public int insertCommentEntity(CommentEntity comment) {
		this.getSqlSession().insert("insertCommentEntity", comment);
		return comment.id;
	}

	@Override
	public List<CommentEntity> getCommentsByExpid(int eid)
	{
		return this.getSqlSession().selectList("getCommentsByExpid",eid);
	}
}
