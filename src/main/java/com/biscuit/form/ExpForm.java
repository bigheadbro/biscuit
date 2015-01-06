package com.biscuit.form;

public class ExpForm
{
	private String name;
	//
	private String owner;
	
	private int rid;
	//
	private String content;
	private String pic;
	private String cover;
	//
	private String gmtCreate;
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
	public String getGmtCreate()
	{
		return gmtCreate;
	}
	public void setGmtCreate(String gmtCreate)
	{
		this.gmtCreate = gmtCreate;
	}
	public String getCover()
	{
		return cover;
	}
	public void setCover(String cover)
	{
		this.cover = cover;
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
