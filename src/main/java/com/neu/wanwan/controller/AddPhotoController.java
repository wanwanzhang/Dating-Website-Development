package com.neu.wanwan.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.neu.wanwan.DAO.UserDAO;
import com.neu.wanwan.POJO.User;

@Controller
public class AddPhotoController {

	@Autowired
	ServletContext context;

	public AddPhotoController() {

	}

	@RequestMapping(value = "/uploadfile.htm", method = RequestMethod.POST)
	protected String uploadFileHandler(@RequestParam("name") String name, @RequestParam("photo") MultipartFile file,
			HttpServletRequest request) {

		if (!file.isEmpty()) {
			try {
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("user");
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
                UserDAO userdao = new UserDAO();
				
				user.setPhotoName(serverFile.getAbsolutePath());
				userdao.addUser(user);
				request.setAttribute("upload", "upload");
				//return "sellerPage";
			} catch (Exception e) {
				request.setAttribute("fail", "fail");
				//return "sellerPage";
			}
		} else {
			request.setAttribute("fail", "fail");
		}
		return "addedphoto";

	}
}
