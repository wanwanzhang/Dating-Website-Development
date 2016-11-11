package com.neu.wanwan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.wanwan.POJO.User;

@Controller
public class LogoutFormController {
//@RequestMapping(value="/logout.htm", method=RequestMethod.POST)

//	 public String login(HttpServletRequest request, HttpServletResponse hsr1) throws Exception {
//	
//		return "LoginForm";
//	}
	@RequestMapping(value="/logout.htm",method = RequestMethod.GET) 
   public String initializeForm(@ModelAttribute("user")User user, BindingResult result) { 
	  //session.invalidate();
       return "LoginForm"; 
	
}
}
