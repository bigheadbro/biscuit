package com.biscuit.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.biscuit.util.StringUtil;
import com.biscuit.entity.ExpEntity;
import com.biscuit.entity.RecipeEntity;
import com.biscuit.form.ExpForm;
import com.biscuit.form.RecipeForm;
import com.biscuit.service.CommonService;
import com.biscuit.util.Util;

@Controller
@RequestMapping("/")
@SessionAttributes({"account"})
public class CommonController extends BaseController{
	private Logger logger = LoggerFactory.getLogger(CommonController.class);
	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;
	
	@RequestMapping(value="/")
	public ModelAndView main(final HttpServletRequest request,final HttpServletResponse response)
	{
		return new ModelAndView(new RedirectView("/index"));
	}
	
	@RequestMapping(value="/index")
	public ModelAndView index(final HttpServletRequest request,final HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("/main/index");
		List<ExpEntity> exps = commonService.getAllExps();
		mv.addObject("exps",exps);
		return mv;
	}
	
	@RequestMapping(value="/squad")
	public ModelAndView squad(final HttpServletRequest request,final HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("/common/squad");
		List<ExpEntity> exps = commonService.getAllExps();
		mv.addObject("exps",exps);
		return mv;
	}
	
	@RequestMapping(value="/exps")
	public ModelAndView exps(final HttpServletRequest request,final HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("/common/exps");
		List<ExpEntity> exps = commonService.getAllExps();
		mv.addObject("exps",exps);
		return mv;
	}
	
	@RequestMapping(value="/exp/{id}")
	public ModelAndView exp(final HttpServletRequest request,final HttpServletResponse response, @PathVariable String id)
	{
		int eid = Integer.valueOf(id);
		ModelAndView mv = new ModelAndView("/common/exp");
		ExpEntity exp = commonService.getExpById(eid);
		RecipeEntity recipe = commonService.getRecipeById(exp.getRid());
		exp.setContent(StringUtil.convertEnterForHtml(exp.getContent()));
		mv.addObject("exp",exp);
		mv.addObject("recipe",recipe);
		mv.addObject("pics",exp.getPic().split("[|]"));
		return mv;
	}
	
	@RequestMapping(value="/addexp")
	public ModelAndView addexp(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("form")ExpForm form, BindingResult result)
	{
		ModelAndView mv = new ModelAndView("/common/addexp");
		List<RecipeEntity> recipes = commonService.getAllRecipes();
		mv.addObject("recipes",recipes);
		if(isDoSubmit(request))
		{
			logger.debug("Add exp to DB");
			commonService.addExp(form);
		}
		return mv;
	}
	
	@RequestMapping(value = "/uploadexp", produces="text/plain;charset=UTF-8")  
	@ResponseBody
	public String uploadexp(HttpServletRequest request, HttpServletResponse response)
	{
		String responseStr="";  
		MultipartHttpServletRequest r = (MultipartHttpServletRequest) request;

        MultipartFile f = r.getFile("productlink");    
        String type = f.getOriginalFilename().substring(f.getOriginalFilename().lastIndexOf(".")).toLowerCase();
        if(!StringUtil.isProperImageFile(type))
        {
        	return "";
        }
        String path = request.getSession().getServletContext().getRealPath("/expimg");
		String link = StringUtil.getTodayString() + "/" + f.getOriginalFilename();
		path += "/" + StringUtil.getTodayString() + "/";
		File file = new File(path + f.getOriginalFilename());
		file.getParentFile().mkdirs();  
		file.getParentFile().mkdirs();  

		try 
		{
			FileCopyUtils.copy(f.getBytes(), file);
			responseStr = link;

		} catch (IOException e) {

		}

		return responseStr;
	}
	
	@RequestMapping(value="/recipes")
	public ModelAndView recipes(final HttpServletRequest request,final HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("/common/recipes");
		List<RecipeEntity> recipes = commonService.getAllRecipes();
		mv.addObject("recipes",recipes);
		return mv;
	}
	
	@RequestMapping(value="/recipe/{id}")
	public ModelAndView recipe(final HttpServletRequest request,final HttpServletResponse response, @PathVariable String id)
	{
		int rid = Integer.valueOf(id);
		ModelAndView mv = new ModelAndView("/common/recipe");
		RecipeEntity recipe = commonService.getRecipeById(rid);
		recipe.setContent(StringUtil.convertEnterForHtml(recipe.getContent()));
		mv.addObject("recipe",recipe);
		return mv;
	}
	
	@RequestMapping(value="/addrecipe")
	public ModelAndView addrecipe(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("form")RecipeForm form, BindingResult result)
	{
		ModelAndView mv = new ModelAndView("/common/addrecipe");
		if(isDoSubmit(request))
		{
			logger.debug("Add recipe to DB");
			commonService.addRecipe(form);
		}
		return mv;
	}
	
	
	
}
