package com.application.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.application.model.LogModel;
import com.application.serviceImpl.CustomerServiceImplementation;

@RestController
@CrossOrigin("*")
public class MainController
{
	public String currDate = "";
	public String currTime = "";
	
	@Autowired
	private CustomerServiceImplementation customerServiceImpl;
	
	@PostMapping(value = "/checkIn")
	public ResponseEntity<LogModel> checkIn(@RequestParam String name)
	{
		String Date = getSystemDate();
		String Time = getSystemTime();
		String ID = name+" "+Time;
		LogModel logmodel = new LogModel(ID,"IN",Time,Date);
		customerServiceImpl.checkIn(logmodel,name);
		System.out.println("Customer CheckIn Info Saved Successfully !!!");
		return new ResponseEntity<LogModel>(logmodel, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getLog")
	public ResponseEntity<List<LogModel>> getLogByDate(@RequestParam String date)
	{
		List<LogModel> customerLogs = customerServiceImpl.getLog(date);
		if(customerLogs.size() != 0)
		{
			System.out.println("Customer Log Details Found on "+date+" are : ");
			for(LogModel library:customerLogs)
			{
		    	System.out.println("Customer ID:"+library.getId()+" ");
				System.out.println("Log Date:"+library.getDate()+" ");
				System.out.println("Log Time:"+library.getTime()+" ");
				System.out.println("Log Type:"+library.getLogType()+" ");
				System.out.println("-------------------------------------------");
		    }
		}
		else
			System.out.print("No Match Found!!!");
		return new ResponseEntity<List<LogModel>>(customerLogs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getLogTime")
	public ResponseEntity<List<LogModel>> getLogByTime(@RequestParam String time)
	{
		List<LogModel> customerLogs = customerServiceImpl.getLogByTime(time);
		if(customerLogs.size() != 0)
		{
			System.out.println("Customer Log Details Found on "+time+" are : ");
			for(LogModel library:customerLogs)
			{
		    	System.out.println("Customer ID:"+library.getId()+" ");
				System.out.println("Log Date:"+library.getDate()+" ");
				System.out.println("Log Time:"+library.getTime()+" ");
				System.out.println("Log Type:"+library.getLogType()+" ");
				System.out.println("-------------------------------------------");
		    }
		}
		else
			System.out.print("No Match Found!!!");
		return new ResponseEntity<List<LogModel>>(customerLogs, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllLog")
	public ResponseEntity<List<LogModel>> getAllLog()
	{
		List<LogModel> customerLogs = customerServiceImpl.getAllLog();
		if(customerLogs.size() != 0)
		{
			System.out.println("Customer Log Details are : ");
			for(LogModel library:customerLogs)
			{
		    	System.out.println("Customer ID:"+library.getId()+" ");
				System.out.println("Log Date:"+library.getDate()+" ");
				System.out.println("Log Time:"+library.getTime()+" ");
				System.out.println("Log Type:"+library.getLogType()+" ");
				System.out.println("-------------------------------------------");
		    }
		}
		else
			System.out.print("No Match Found!!!");
		return new ResponseEntity<List<LogModel>>(customerLogs, HttpStatus.OK);
	}

	@PostMapping(value = "/checkOut")
	public ResponseEntity<LogModel> checkOut(@RequestParam String name)
	{
		String Date = getSystemDate();
		String Time = getSystemTime();
		String ID = name+" "+Time;
		LogModel logmodel = new LogModel(ID,"OUT",Time,Date);
		customerServiceImpl.checkOut(logmodel,name);
		System.out.println("Customer CheckOut Info Saved Successfully !!!");
		return new ResponseEntity<LogModel>(logmodel, HttpStatus.OK);
	}
	
	public String getSystemDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");  
	    Date date = new Date();  
	    String[] values = formatter.format(date).split(" ");
	    currDate = values[0];
	    currTime = values[1];
	    return currDate;
	}
	
	public String getSystemTime()
	{
		return currTime;
	}
}