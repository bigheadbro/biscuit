package com.biscuit.dao;

import java.util.List;

import com.biscuit.entity.RecipeEntity;;

public interface RecipeDAO {

	public int insertRecipe(RecipeEntity Recipe);

	public List<RecipeEntity> getAllRecipes();
	
	public RecipeEntity getRecipeById(int id);
}
