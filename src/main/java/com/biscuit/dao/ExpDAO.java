package com.biscuit.dao;

import java.util.List;

import com.biscuit.entity.ExpEntity;;

public interface ExpDAO {

	public int insertExp(ExpEntity exp);

	public List<ExpEntity> getAllExps();
	
	public ExpEntity getExpById(int id);
}
