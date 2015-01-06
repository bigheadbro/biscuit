package com.biscuit.entity;

import java.io.Serializable;

public class RecipeEntity implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5735837320809533819L;
	//
	private int id;
	//
	private String name;
	//
	private String content;
	//
	private String gmtCreate;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

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