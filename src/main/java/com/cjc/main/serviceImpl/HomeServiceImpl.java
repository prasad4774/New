package com.cjc.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Student;
import com.cjc.main.repository.HomeRepository;
import com.cjc.main.service.HomeService;

@Service
public class HomeServiceImpl  implements HomeService
{

	@Autowired
	HomeRepository hr;
	
	
	@Override
	public void saveData(Student s)
	{
		hr.save(s);
	}


	@Override
	public Student logincheck(String un, String ps ) 
	{
	     Student s= new Student();
		hr.findAllByUnameAndPassword(un, ps);
		
		return s;
	}


	@Override
	public Iterable displayAllData() {
		
		return hr.findAll();
	}

}
