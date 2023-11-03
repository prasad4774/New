package com.cjc.main.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cjc.main.model.Student;
import com.cjc.main.service.HomeService;

@RestController
public class HomeController
{

	@Autowired
	HomeService hs;
	
	
	
	// get data from database
	@RequestMapping(value = "/getAllData", method = RequestMethod.GET)
	public Iterable<Student> prelogin()
	{
		Iterable list=hs.displayAllData();
		return list;
	}
	
	
	
	// get Single data from DataBase (edit this method take return type value from login check )
 	@GetMapping("/singleuser/{uname}/{password}")
	public Student loginCheck(@PathVariable("uname") String un,@PathVariable("password") String ps)
	{
		
		
	Student s = hs.logincheck(un,ps);
		
	
		
		return s ;
	}
	
	
	//insert data
	@PostMapping("/postData")
	public String RegData(@RequestBody Student st)
	{
		hs.saveData(st);
		return "success Full register";
	}
	
	
	
	
	
	
	
//	@RequestMapping("/registration")
//	public String preRegister()
//	{
//		return "registration";
//	}
//	
//	@RequestMapping("/reg")
//	public String RegData(@ModelAttribute Student st)
//	{
//		hs.saveData(st);
//		return "login";
//	}
//	
//	@RequestMapping("/login")
//	public String loginCheck(@RequestParam("uname") String un,@RequestParam("password") String ps,Model m)
//	{
//		
//		hs.logincheck(un,ps);
//		
//		Iterable list=hs.displayAllData();
//		m.addAttribute("data", list);
//		
//		return "success";
//	}
	
	
	
	
	
}
