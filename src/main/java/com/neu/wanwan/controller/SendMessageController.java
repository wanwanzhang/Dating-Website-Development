package com.neu.wanwan.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.wanwan.DAO.MessageDAO;
import com.neu.wanwan.POJO.Message;
import com.neu.wanwan.POJO.User;


@Controller
@RequestMapping("/sendmessage.htm")
public class SendMessageController {

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView doSubmitAction(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
HttpSession session = request.getSession();
User user = (User) session.getAttribute("user");

		String contactname = request.getParameter("name");
		String username = user.getUsername();
		session.setAttribute("to", contactname);
		session.setAttribute("from", username);
		
		
		
//		System.out.println("ffffffromuser"+fromuser);
//		String messageDate = String.valueOf(new Date());
//		String message = request.getParameter("message");
//		System.out.println("ffffffromuser"+fromuser);
//		MessageDAO messagedao = new MessageDAO();
//		Message msg=messagedao.create(contactname, fromuser, message, messageDate);
		
	
		ModelAndView mv = new ModelAndView("sendMessage", "user", user);
		return mv;
	}
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String initializeForm(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request) {
//		
//		return "sendmessage";
//	}

}
