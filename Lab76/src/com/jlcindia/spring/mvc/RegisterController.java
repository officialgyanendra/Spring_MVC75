package com.jlcindia.spring.mvc;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
@Controller
@SessionAttributes
public class RegisterController{
	@Autowired
  private StudentValidator studentValidator; 
	@RequestMapping(value="/registerStudent",method=RequestMethod.POST)
	public String registerStudent(@ModelAttribute("student") Student stu,BindingResult result)throws ServletException{
		System.out.println("registerStudent()");
		studentValidator.validate(stu, result);
		if(result.hasErrors()){
			System.out.println(result.getErrorCount());
			return "register";
		}
		System.out.println(stu.getSid());
		System.out.println(stu.getSname());
		System.out.println(stu.getEmail());
		System.out.println(stu.getPhone());
		System.out.println(stu.getGender());
		System.out.println(stu.getQualification());
		String tim[]=stu.getTimings();
		for(int i=0;i<tim.length;i++){
			System.out.println(tim[i]);
		}
		System.out.println(stu.getRemark());
		return "home";
		}
	 @RequestMapping(value="/register")
	 protected String showRegisterForm(Map model)throws ServletException{
		 System.out.println("Show Register Form");
		 Student stu=new Student();
		 stu.setSid("JLC-99");
		 model.put("student",stu);
		 return "register";
	 }

}
