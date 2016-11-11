package com.neu.wanwan.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.wanwan.DAO.UserDAO;
import com.neu.wanwan.POJO.Profile;
import com.neu.wanwan.POJO.User;

@Controller
public class LoginFormController {
	@Autowired
	@Qualifier("loginValidator")
	LoginValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
	@RequestMapping(value="/login.htm", method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "LoginForm";
		}
         UserDAO userDao = new UserDAO();
      	 String username = request.getParameter("username");
         String password = request.getParameter("password");
         HttpSession session= request.getSession();
         User u = userDao.get(username, password);
         session.setAttribute("currentuser",u);
         System.out.println("inlogincontroller");
         List<User> list = new ArrayList<User>();		         		
         String hql = "From User";
         Query query = userDao.getSession().createQuery(hql);
         list = query.list();
         System.out.println(username);
         System.out.println(password);
         session.setAttribute("showusers", list);
         if(username.equals("admin")&&password.equals("admin")){
        	 System.out.println("admin");
     		return "viewdb";
     	}else{
     		if(u!=null){
     			System.out.println("notadmin");
           	 return "home";
     		}else{
     			System.out.println("notadmin");
     			session.setAttribute("checkNoUser", "NoUser");
     			return "LoginForm";
     		}
            	
     	}    
         
	}
	@RequestMapping(value="/login.htm",method = RequestMethod.GET) 
    public String initializeForm(@ModelAttribute("user")User user, BindingResult result) throws SQLException { 
//		UserDAO userDao = new UserDAO();
//		User u = new User();
//		u.setUsername("admin");
//		u.setPassword("admin");
//		userDao.addUser(u);
        return "LoginForm"; 
        
}
}
