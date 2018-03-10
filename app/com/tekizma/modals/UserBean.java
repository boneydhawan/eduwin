package com.tekizma.modals;


public class UserBean {
	
	private Long id;
    private String name;
    private String place;
    private Long phoneNumber;
    private boolean isOldUser;
    
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
	public boolean isOldUser() {
		return isOldUser;
	}
	public void setOldUser(boolean isOldUser) {
		this.isOldUser = isOldUser;
	}
    
}
