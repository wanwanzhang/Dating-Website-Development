package com.neu.wanwan.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.neu.wanwan.Exception.AdException;
import com.neu.wanwan.POJO.Email;
import com.neu.wanwan.POJO.Message;
import com.neu.wanwan.POJO.User;

public class MessageDAO extends DAO {
	
	public User search(String username){
		begin();
		
		Query q = getSession().createQuery("From User u where u.username=:username");
		q.setString("username", username);
		User user = (User) q.uniqueResult();
		System.out.println(user.getId());
		 
         commit();
         return user;
		
	          
		 
	 }
	 public Message create(String userName,String touser, String message, String messageDate)
	            throws AdException {
	        try {
	        	 Transaction tx = getSession().beginTransaction();
	            System.out.println("inside DAO");

	            Message msg = new Message();
	            msg.setTouser(touser);
	            msg.setMessage(message);
                msg.setMessageDate(messageDate);               
                msg.setUsername(userName);

	            
	            getSession().save(msg);
	            tx.commit();
	            
	              if (!tx.wasCommitted()){
	            	    tx.commit();
	            	  }
	              
	              
		           
		           User user = search(userName);
		           tx.begin();
		           System.out.println(user.getId());
		           msg.setUser(user);
		           
		           getSession().update(msg);
		           
		           System.out.println(msg.getUser().getUsername());
		           tx.commit();
	           
	            return msg;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create user " + username, e);
	            throw new AdException("Exception while creating message: " + e.getMessage());
	        }
	    }
}
