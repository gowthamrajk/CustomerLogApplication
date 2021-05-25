package com.application.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.application.model.LogModel;

public interface CustomerRepository extends CrudRepository<LogModel, String>
{
	public List<LogModel> getLogByDate(String date); 
	
	public List<LogModel> getLogByTime(String time);
}