package com.neu.wanwan.controller;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.wanwan.DAO.ContactDAO;
import com.neu.wanwan.DAO.UserDAO;
import com.neu.wanwan.POJO.Contact;
import com.neu.wanwan.POJO.User;


@Controller
@RequestMapping("/addcontact.htm")
public class AddContactController {

	@RequestMapping(value="/addcontact.htm",method=RequestMethod.GET)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) 
    		throws Exception {
		UserDAO userDao = new UserDAO();
		//list contacts 
		ContactDAO contactdao = new ContactDAO();
		HttpSession session = request.getSession();
		String contactName = request.getParameter("name");	
		System.out.println("DDDDD"+contactName);
		User user = (User)session.getAttribute("user");
		String username = user.getUsername();
		System.out.println(user.getUsername());
		System.out.println("UUUUU"+user);
//		

//		
		Date date = new Date();
		Contact contact= contactdao.create(username, contactName, String.valueOf(date));
		//contact.setUser(user);
		System.out.println("USER IN CONTACT"+contact.getUser().getUsername());
		
		//ModelAndView mv = new ModelAndView("userprofile", "user", user);
		//get all contacts of this user
		String hql = "From Contact where userID =:userID";
		Query query = userDao.getSession().createQuery(hql);
		
		long userID =user.getId();
		System.out.println(userID);
		query.setLong("userID", userID);
		List<Contact> contactlist= query.list();
		System.out.println("USER IN CONTACT"+contactlist);
		ModelAndView mv = new ModelAndView("viewContacts", "contactlist",contactlist);
		
		return mv;
	}

	

}
