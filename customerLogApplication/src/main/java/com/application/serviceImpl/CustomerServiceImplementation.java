package com.application.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.application.dao.CustomerRepository;
import com.application.model.LogModel;
import com.application.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public LogModel checkIn(LogModel logmodel, String name) 
	{
		return customerRepo.save(logmodel);
	}

	@Override
	public LogModel checkOut(LogModel logmodel, String name) 
	{
		return customerRepo.save(logmodel);
	}

	@Override
	public List<LogModel> getLog(String date) 
	{
		return customerRepo.getLogByDate(date);
	}
	
	@Override
	public List<LogModel> getLogByTime(String time) 
	{
		return customerRepo.getLogByTime(time);
	}

	@Override
	public List<LogModel> getAllLog() 
	{
		return (List<LogModel>)customerRepo.findAll();
	}
}