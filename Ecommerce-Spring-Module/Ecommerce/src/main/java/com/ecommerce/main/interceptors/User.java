package com.ecommerce.main.interceptors;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
    private String id;
    private String emailAddress;
    private String  role;
    private String userName;
    private long userId;
   
    public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

  

    public String getEmailAddress () {
        return emailAddress;
    }

    public void setEmailAddress (String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString () {
        return "User{" +
                            "id=" + id +
                            ", emailAddress='" + emailAddress + '\'' +
                            ", userRole='" + role + '\''+
                            '}';
    }
}