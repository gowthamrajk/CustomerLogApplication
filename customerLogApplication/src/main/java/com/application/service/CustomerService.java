package com.application.service;

import com.application.model.LogModel;
import java.util.List;

public interface CustomerService 
{
	public LogModel checkIn(LogModel logmodel, String name);
	
	public LogModel checkOut(LogModel logmodel, String name);	
	
	public List<LogModel> getLog(String date);
	
	public List<LogModel> getLogByTime(String time);
	
	public List<LogModel> getAllLog();
}