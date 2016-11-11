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

import com.neu.wanwan.DAO.MessageDAO;
import com.neu.wanwan.DAO.UserDAO;
import com.neu.wanwan.POJO.Contact;
import com.neu.wanwan.POJO.Message;
import com.neu.wanwan.POJO.User;
@Controller
@RequestMapping("/deletemessage.htm")
public class DeleteMessageController {
	@RequestMapping(value="/deletemessage.htm", method=RequestMethod.GET)
	protected String doSubmitAction(@ModelAttribute("user") User user1, BindingResult result,
			HttpServletRequest request) throws Exception {
	HttpSession session = request.getSession();
	    //User user = (User) session.getAttribute("user");
		UserDAO userdao = new UserDAO();
		
		String username = request.getParameter("name");
				Query q = userdao.getSession().createQuery("From User where username=:username");
				
				q.setString("username", username);
				User u = (User)q.uniqueResult();
				System.out.println(u);
				long id =u.getId();
						
		Message msg = userdao.search(id);
		userdao.getSession().delete(msg);
		
		
             return "viewMessage";
         }
}
