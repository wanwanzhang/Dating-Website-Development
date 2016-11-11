package com.neu.wanwan.DAO;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Transaction;

import com.neu.wanwan.Exception.AdException;
import com.neu.wanwan.POJO.Email;
import com.neu.wanwan.POJO.Message;
import com.neu.wanwan.POJO.User;
import org.springframework.stereotype.Component;

public class UserDAO extends DAO {

    public UserDAO() {
    }
    public Message search(long userID){
		begin();
		
		Query q = getSession().createQuery("From Message where userID=:userID");
		q.setLong("userID", userID);
		Message msg = (Message) q.uniqueResult();
		
		 
         commit();
         return msg;       
		 
	 }
    
    public void addUser(User user) throws SQLException {
    	
        //Session hibsession = sf.openSession();
        Transaction tx = null;
        try {
            tx = getSession().beginTransaction();
            getSession().save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
        	getSession().close();
        }

    }
    public User get(String username,String password)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where username = :username and password = :password");
            q.setString("username", username);
            q.setString("password", password);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
  

    public User create(String username, String password,String emailId, String firstName, String lastName)
            throws AdException {
        try {
            begin();
            System.out.println("inside DAO");
            
            Email email=new Email(emailId);
            User user=new User(username,password);
            
            user.setFirstName(firstName);
            user.setLastName(lastName);
            
            user.setEmail(email);
            
            email.setUser(user);
            
            getSession().save(user);
            
            commit();
            
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getUsername(), e);
        }
    }
    public User userExists(String uname) throws AdException{
    	try {
            begin();
            Query q = getSession().createQuery("from User where username = :username");
            q.setString("username", uname);
            //q.setString("password", password);
            User user = (User) q.uniqueResult();
            commit();
            return user;
            
        } catch (HibernateException e) {
            rollback();
            return null;
        }
    
    
    }
}