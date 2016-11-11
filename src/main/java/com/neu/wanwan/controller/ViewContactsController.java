package com.neu.wanwan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.wanwan.DAO.UserDAO;
import com.neu.wanwan.POJO.Contact;
import com.neu.wanwan.POJO.User;
@Controller
@RequestMapping("/viewcontacts.htm")
public class ViewContactsController {
	@RequestMapping(value="/viewcontacts.htm", method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) throws Exception {
		
		HttpSession session= request.getSession();
		UserDAO userDao = new UserDAO();
   	
		List<Contact> list = new ArrayList<Contact>();		
		String username =user.getUsername();
		String hql = "From Contact c where c.username=:username";
		
		Query query = userDao.getSession().createQuery(hql);
		query.setString("username", username);
		list = query.list();
		session.setAttribute("showcontacts", list);
		//table showing logic thing with fromuser,message, reply, messagedate
             return "viewContacts";
         }
	
	@RequestMapping(value="/viewcontacts.htm",method = RequestMethod.GET) 
    public String initializeForm(@ModelAttribute("user")User user, BindingResult result) { 
   
        return "viewContacts"; 
	
}
}
