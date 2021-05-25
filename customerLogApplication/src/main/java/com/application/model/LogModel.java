package com.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerlog", catalog = "customer")
public class LogModel 
{
	@Id
	private String Id;
	private String logType;
	private String time;
	private String date;
	
	public LogModel()
	{
		super();
	}

	public LogModel(String id, String logType, String time, String date) 
	{
		super();
		Id = id;
		this.logType = logType;
		this.time = time;
		this.date = date;
	}

	public String getId() 
	{
		return Id;
	}

	public void setId(String id) 
	{
		Id = id;
	}

	public String getLogType() 
	{
		return logType;
	}

	public void setLogType(String logType) 
	{
		this.logType = logType;
	}

	public String getTime() 
	{
		return time;
	}

	public void setTime(String time) 
	{
		this.time = time;
	}

	public String getDate() 
	{
		return date;
	}

	public void setDate(String date) 
	{
		this.date = date;
	}
}