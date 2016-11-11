package com.neu.wanwan.POJO;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;




/**
 * @author Wanwan Zhang
 *
 */
@Entity
@Table(name = "contacttable")
public class Contact {

	@Id 
	@GeneratedValue
	@Column(name="contactid", unique = true, nullable = false)
    private long id;
	
	@Transient//will store in contact table
	private String username;
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userID")
    private User user;
	

	@Column(name = "contactName")
	    private String contactName;

	@Column(name = "dateAdded")
	    private String dateAdded;
	
	public Contact(){
		
	}
	
	public Contact(long id, String username, User user, String contactName,  String dateAdded) {
		super();
		this.id = id;
		this.username = username;
		this.user = user;
		this.contactName = contactName;
	
		this.dateAdded = dateAdded;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}



	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String date) {
		this.dateAdded = date;
	}

	
	
}
