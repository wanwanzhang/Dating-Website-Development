package com.neu.wanwan.POJO;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.web.multipart.MultipartFile;





@Entity
@Table(name="usertable")

public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private long id;
	
	@Column(name="username")
    private String username;
	
	@Column(name="password")
    private String password;
	
	@Column(name = "firstName")
	private String firstName;
	
	@Column(name ="lastName")
	private String lastName;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="user")
	private Set<Contact> contacts = new HashSet<Contact>();

	@OneToMany(fetch=FetchType.LAZY,mappedBy="user")
	private Set<Message> messagelist = new HashSet<Message>();
	
	
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
    private Email email;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="user", cascade=CascadeType.ALL)
	@JoinColumn(name="profile")
    private Profile profile;
	
	@Column(name="photoName")
	   private String photoName; // Map with hibernate
	@Transient
	    private MultipartFile photo; // Use by Data Binder

	
    public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public MultipartFile getPhoto() {
		return photo;
	}

	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public User() {
    }

   

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

	public Email getEmail() {
		return email;
		
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	public void addContact(Contact contact) {
		getContacts().add(contact);
    }
	

}