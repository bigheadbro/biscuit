package com.biscuit.entity;

import java.io.Serializable;

public class ExpEntity implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2512587797716514933L;
	//
	private int id;
	//
	private String name;
	private int rid;
	//
	private String owner;
	//
	private String content;
	private String pic;
	private String cover;
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
	public String getOwner()
	{
		return owner;
	}
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getPic()
	{
		return pic;
	}
	public void setPic(String pic)
	{
		this.pic = pic;
	}
	public String getCover()
	{
		return cover;
	}
	public void setCover(String cover)
	{
		this.cover = cover;
	}
	public String getGmtCreate()
	{
		return gmtCreate;
	}
	public void setGmtCreate(String gmtCreate)
	{
		this.gmtCreate = gmtCreate;
	}
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	public int getRid()
	{
		return rid;
	}
	public void setRid(int rid)
	{
		this.rid = rid;
	}
}