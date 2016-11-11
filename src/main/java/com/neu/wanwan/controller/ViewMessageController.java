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
@RequestMapping("/viewmessage.htm")
public class ViewMessageController {
	@RequestMapping(value="/viewmessage.htm", method=RequestMethod.GET)
	protected String doSubmitAction(@ModelAttribute("user") User user1, BindingResult result,
			HttpServletRequest request) throws Exception {
	HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		UserDAO userdao = new UserDAO();
		
		MessageDAO md = new MessageDAO();
		
		List<Message> list = new ArrayList<Message>();		
		long userID =user.getId();
		String hql = "From Message where userID=:userID";
		System.out.println("llllll"+user.getUsername());
		Query query = userdao.getSession().createQuery(hql);
		query.setLong("userID", userID);
		list = query.list();
		System.out.println("llllll"+list);
		session.setAttribute("showmessages", list);
		//table showing logic thing with fromuser,message, reply, messagedate
             return "viewMessage";
         }
	
//	@RequestMapping(value="/viewmessage.htm",method = RequestMethod.GET) 
//    public String initializeForm(@ModelAttribute("user")User user, BindingResult result) { 
//		System.out.println("llllll");
//        return "viewMessage"; 
//	
//}
}
