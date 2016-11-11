package com.neu.wanwan.DAO;

import org.hibernate.HibernateException;

import com.neu.wanwan.Exception.AdException;
import com.neu.wanwan.POJO.Profile;
import com.neu.wanwan.POJO.User;



public class ProfileDAO extends DAO {

public void save(User user, Profile profile) throws AdException{
		
		try {
			begin();
			
			getSession().saveOrUpdate(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("q"+e);
		}
		finally{
			close();
		}
	}
}
