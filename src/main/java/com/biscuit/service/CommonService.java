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
import com.biscuit.entity.ExpEntity;
import com.biscuit.form.ExpForm;
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
	@Qualifier("commentDAO")
	private CommentDAO commentDAO;
	
	public int addExp(ExpForm form)
	{
		ExpEntity exp = new ExpEntity();
		exp.setName(form.getName());
		exp.setContent(form.getContent());
		exp.setGmtCreate(StringUtil.formatDate(form.getGmtCreate(), "yyyy.MM.dd", "yyyy-MM-dd  HH:mm:ss"));
		exp.setOwner(form.getOwner());
		exp.setPic(form.getPic());
		exp.setCover(form.getCover());
		return expDAO.insertExp(exp);
	}
	
	public List<ExpEntity> getAllExps()
	{
		return expDAO.getAllExps();
	}
	
	public ExpEntity getExpById(int id)
	{
		return expDAO.getExpById(id);
	}
}