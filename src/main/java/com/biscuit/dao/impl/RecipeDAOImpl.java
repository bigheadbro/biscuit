package com.biscuit.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.biscuit.dao.RecipeDAO;
import com.biscuit.entity.RecipeEntity;

@Repository("recipeDAO")
public class RecipeDAOImpl extends SqlSessionDaoSupport implements RecipeDAO {

	@Override
	public int insertRecipe(RecipeEntity Recipe)
	{
		this.getSqlSession().insert("insertRecipe", Recipe);
		return Recipe.getId();
	}

	@Override
	public List<RecipeEntity> getAllRecipes()
	{
		return this.getSqlSession().selectList("getAllRecipes");
	}
	
	@Override
	public RecipeEntity getRecipeById(int id)
	{
		return this.getSqlSession().selectOne("getRecipeById",id);
	}
}
