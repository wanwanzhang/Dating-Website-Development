package com.neu.wanwan.DAO;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.neu.wanwan.Exception.AdException;
import com.neu.wanwan.POJO.Contact;
import com.neu.wanwan.POJO.Email;
import com.neu.wanwan.POJO.Message;
import com.neu.wanwan.POJO.User;

public class ContactDAO extends DAO {
	 
	public User search(String username){
		begin();
		
		Query q = getSession().createQuery("From User u where u.username=:username");
		q.setString("username", username);
		User user = (User) q.uniqueResult();
		System.out.println(user.getId());
		 
         commit();
         return user;
		
	          
		 
	 }

	 public Contact create(String username,String contactName, String dateAdded)
	            throws AdException {
	        try {
	        	
	        	  Transaction tx = getSession().beginTransaction();
	            System.out.println("inside DAO");
	            
	    
	           Contact contact = new Contact();
	           contact.setContactName(contactName);
	           contact.setUsername(username);
	           contact.setDateAdded(dateAdded);

	            getSession().save(contact);
	            tx.commit();
	              if (!tx.wasCommitted()){
	            	    tx.commit();
	            	  }
	            tx.begin();
	           
	           User user = search(username);
	           System.out.println(user.getId());
	           contact.setUser(user);
	           getSession().update(contact);
	           System.out.println(contact.getUser().getUsername());
	           tx.commit();

	            return contact;
	        } catch (HibernateException e) {
	            rollback();
	            //throw new AdException("Could not create contact " + username, e);
	            throw new AdException("Exception while creating contact: " + e.getMessage());
	        }
	    }
}
