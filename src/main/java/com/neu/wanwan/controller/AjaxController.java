package com.neu.wanwan.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.io.PrintWriter;
import com.neu.wanwan.DAO.UserDAO;
import com.neu.wanwan.Exception.AdException;
import com.neu.wanwan.POJO.User;

@Controller
@RequestMapping("/ajax.htm")
public class AjaxController {
	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView doSubmitAction(@ModelAttribute("user") User user, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		System.out.print("action:"+action);
		UserDAO userDao = new UserDAO();
		if(action.equals("ajaxCheck")) {
           
			String username = request.getParameter("name");
			
			System.out.println("wwwwww"+username);
			
            if(userDao.userExists(username)!=null){
          
                 JSONObject obj = new JSONObject();
                 obj.put("message","Username already exists");
                 PrintWriter out = response.getWriter();
             
                 out.println(obj);
                 System.out.println("Username is nonavailable");
			       }
			      else{
			          
			    	  System.out.println("Username is available");
			      }
		}
			        return null;

//}return "addUserForm";
//	}
	}
	
}
