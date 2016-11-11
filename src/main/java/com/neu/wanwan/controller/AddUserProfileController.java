package com.neu.wanwan.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.wanwan.DAO.ProfileDAO;
import com.neu.wanwan.DAO.UserDAO;
import com.neu.wanwan.POJO.Profile;
import com.neu.wanwan.POJO.User;



@Controller
public class AddUserProfileController {
	@Autowired
	ServletContext servletContext;

	@RequestMapping(value="/addprofile.htm", method=RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) throws Exception {
	
		//User user = (User) command;
		HttpSession session = request.getSession();
		
		//User user = (User)session.getAttribute("user");
		Profile p = new Profile();
	    //int id = Integer.parseInt(request.getParameter("id"));
		p.setCity(request.getParameter("city"));
		p.setUser(user);
	
	    user.setProfile(p);

		ProfileDAO profiledao = new ProfileDAO();
		profiledao.save(user, p);
		
		return "addedProfile"; 

}
	@RequestMapping(value="/addprofile.htm",method = RequestMethod.GET) 
    public String initializeForm(@ModelAttribute("profile")Profile profile, BindingResult result) { 
   
        return "addProfile"; 
	
}
}
