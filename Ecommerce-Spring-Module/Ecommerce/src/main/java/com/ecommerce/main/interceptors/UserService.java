package com.ecommerce.main.interceptors;

public interface UserService {

    User loginUser (User user);
    public boolean addUser(User user) ;
    public boolean removeUser(User user);
}

