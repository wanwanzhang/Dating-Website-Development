package com.neu.wanwan.controller;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.neu.wanwan.POJO.User;

import org.springframework.validation.ValidationUtils;

@Component
public class PhotoValidator implements Validator {
	
	 private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)";
	 
    public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }
    
    
    public void validate(Object obj, Errors errors)
    {
    	Pattern pattern = Pattern.compile(IMAGE_PATTERN);
        Matcher matcher;
        MultipartFile photo;
        ValidationUtils.rejectIfEmpty(errors, "photo","Test", "Field cannot be empty");
        
        User user = (User) obj;
        photo = user.getPhoto();
        matcher = pattern.matcher(photo.getOriginalFilename());
        
        if(0 == photo.getSize()) {
           errors.rejectValue("photo","Test","File is empty");
        }
              if(!matcher.matches()) {
             errors.rejectValue("photo","Test","Invalid Image Format");
        }
        
        if(5000000 < photo.getSize()) {
             errors.rejectValue("photo","Test","File size is over 5mb !");
        }
    	
    	
    	
    	
//        User user = (User) obj;
//        System.out.println("USER PHOT" + user.getPhoto().getSize());
//        if(user.getPhoto().getSize()== 0){
//        	errors.rejectValue("photo", "required.fileUpload");
//        }
       
    }
}
