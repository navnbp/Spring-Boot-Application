package com.navnbp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.ModelAndView;

import com.navnbp.entity.UserDetail;
import com.navnbp.service.UserDetailService;

@Controller()

public class UserDetailController {
	
	@Autowired
	private UserDetailService loginService;
	
	
	

	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) 
	{	
		model.addAttribute("login", new UserDetail());
		
//		Login login= loginService.test();
		return "login/signin";

	}
	
	
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	@ResponseBody
	public String validate(@ModelAttribute UserDetail login) 
	{
		System.out.println("Login Post");
		
		return loginService.validate(login);
		
	}
	
	@RequestMapping(value="/login/error", method = RequestMethod.GET)
	public String error() 
	{
		
		return "error";
		
	}
	
	@RequestMapping(value="/login/logout", method = RequestMethod.GET)
	public String logout() 
	{
		
		return "error";
		
	}

}
