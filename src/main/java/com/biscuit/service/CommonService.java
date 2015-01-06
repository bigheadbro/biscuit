package com.biscuit.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import com.biscuit.common.Result;
import com.biscuit.dao.CommentDAO;
import com.biscuit.dao.ExpDAO;
import com.biscuit.dao.RecipeDAO;
import com.biscuit.entity.ExpEntity;
import com.biscuit.entity.RecipeEntity;
import com.biscuit.form.ExpForm;
import com.biscuit.form.RecipeForm;
import com.biscuit.util.StringUtil;


/**
 * @author guichaoqun
 *
 */
@Service("commonService")
public class CommonService {
	private Logger logger = LoggerFactory.getLogger(CommonService.class);
	@Autowired
	@Qualifier("expDAO")
	private ExpDAO expDAO;
	
	@Autowired
	@Qualifier("recipeDAO")
	private RecipeDAO recipeDAO;
	
	@Autowired
	@Qualifier("commentDAO")
	private CommentDAO commentDAO;
	
	public int addExp(ExpForm form)
	{
		ExpEntity exp = new ExpEntity();
		exp.setName(form.getName());
		exp.setRid(form.getRid());
		exp.setContent(form.getContent());
		exp.setGmtCreate(StringUtil.formatDate(form.getGmtCreate(), "yyyy.MM.dd", "yyyy-MM-dd  HH:mm:ss"));
		exp.setOwner(form.getOwner());
		exp.setPic(form.getPic());
		exp.setCover(form.getCover());
		return expDAO.insertExp(exp);
	}
	
	public int addRecipe(RecipeForm form)
	{
		RecipeEntity recipe = new RecipeEntity();
		recipe.setName(form.getName());
		recipe.setContent(form.getContent());
		recipe.setGmtCreate(StringUtil.formatDate(form.getGmtCreate(), "yyyy.MM.dd", "yyyy-MM-dd  HH:mm:ss"));
		return recipeDAO.insertRecipe(recipe);
	}
	
	public List<ExpEntity> getAllExps()
	{
		return expDAO.getAllExps();
	}
	
	public ExpEntity getExpById(int id)
	{
		return expDAO.getExpById(id);
	}
	
	public RecipeEntity getRecipeById(int id)
	{
		return recipeDAO.getRecipeById(id);
	}
	
	public List<RecipeEntity> getAllRecipes()
	{
		return recipeDAO.getAllRecipes();
	}
}