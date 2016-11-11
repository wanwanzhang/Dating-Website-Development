package com.neu.wanwan.POJO;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "messagetable")
public class Message {
	@Id 
	@GeneratedValue
	@Column(name="messageid", unique = true, nullable = false)
    private long id;
	
	
	@Transient//will store in contact table
	private String username;
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="userID")
    private User user;
	
	
	@Column(name = "touser")
	    private String touser;
	@Column(name = "message")
	    private String message;
	@Column(name = "messageDate")
	    private String messageDate;
	    
	    public Message(){
	    	
	    }
	    
		public Message(long id, String username, User user, String touser, String message, String messageDate) {
			super();
			this.id = id;
			this.username = username;
			this.user = user;
			this.touser = touser;
			this.message = message;
			this.messageDate = messageDate;
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



	

	



		public String getTouser() {
			return touser;
		}

		public void setTouser(String touser) {
			this.touser = touser;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getMessageDate() {
			return messageDate;
		}

		public void setMessageDate(String messageDate) {
			this.messageDate = messageDate;
		}
	    
}
