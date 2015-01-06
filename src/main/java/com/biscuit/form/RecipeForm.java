package com.biscuit.form;

public class RecipeForm
{
	private String name;
	private String content;
	private String gmtCreate;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getGmtCreate()
	{
		return gmtCreate;
	}
	public void setGmtCreate(String gmtCreate)
	{
		this.gmtCreate = gmtCreate;
	}
}
