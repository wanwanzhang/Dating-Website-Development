package com.neu.wanwan.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.wanwan.DAO.UserDAO;
import com.neu.wanwan.POJO.Contact;
import com.neu.wanwan.POJO.User;


@Controller("/home.htm")
public class HomeController {
	@RequestMapping(method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) throws Exception {
		
		  HttpSession session= request.getSession();
		List<User> list = new ArrayList<User>();		
		 UserDAO userDao = new UserDAO();
 		String hql = "From User";
 		Query query = userDao.getSession().createQuery(hql);
 		list = query.list();
 		session.setAttribute("showusers", list);
 		session.setAttribute("user", user);
 		return "home";
	
				
	}

}

