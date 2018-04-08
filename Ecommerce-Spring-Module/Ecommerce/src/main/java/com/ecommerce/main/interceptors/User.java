package com.ecommerce.main.interceptors;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
    private Long id;
    private String name;
    private String emailAddress;
    private String  role;

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
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
                            ", name='" + name + '\'' +
                            ", emailAddress='" + emailAddress + '\'' +
                            ", userRole='" + role + '\''+
                            '}';
    }
}