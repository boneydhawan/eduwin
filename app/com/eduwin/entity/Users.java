package com.eduwin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.eduwin.coreServices.Persistent;

@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Users.findAll", query = "SELECT b FROM Users b"),
		@NamedQuery(name = "Users.findById", query = "SELECT b FROM Users b WHERE b.id = :id"),
		@NamedQuery(name = "Users.findByPhoneNumber", query = "SELECT b FROM Users b WHERE b.phoneNumber = :phoneNumber")})
public class Users extends Persistent{
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
    @SequenceGenerator(name="users_seq", sequenceName="users_seq")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="users_seq")
	private Long id;

	@Column(name = "UserName")
    private String name;
     
    @Column(name = "User_Place")
    private String place;
    
    @Column(name = "User_Mobile_No")
    private Long phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
            
}
