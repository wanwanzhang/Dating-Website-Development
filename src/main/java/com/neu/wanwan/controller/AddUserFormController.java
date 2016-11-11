package com.neu.wanwan.controller;

import java.io.File;
import java.io.PrintWriter;
import org.json.JSONObject;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.wanwan.DAO.UserDAO;
import com.neu.wanwan.Exception.AdException;
import com.neu.wanwan.POJO.User;


@Controller
@RequestMapping("/adduser.htm")
public class AddUserFormController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;	

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		System.out.print("test1");
		
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "addUserForm";
		}

		try {
		
	UserDAO userd = new UserDAO();					
	User u = userd.create(user.getUsername(), user.getPassword(), user.getEmail().getEmailId(), user.getFirstName(), user.getLastName());
	System.out.print(u);
	session.setAttribute("user", u);
						
		} catch (AdException e) {
	System.out.println("Exception: " + e.getMessage());
					}			
return "addedUser";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {
		System.out.print("test4");
		return "addUserForm";
	}
}