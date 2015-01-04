package com.biscuit.dao;

import java.util.List;

import com.biscuit.entity.CommentEntity;;

public interface CommentDAO {

	public int insertCommentEntity(CommentEntity comment);

	public List<CommentEntity> getCommentsByExpid(int eid);
}
