package com.ex.services;

import com.ex.dao.UserDao;
import com.ex.model.User;

public class UserService {
	
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }
    
    // this is the logic behind user login to authenticate a user
    // using the method created in userdao that selects the user by email from the database
    // if the email and password matches the info in the database exactly then the login is successful 
    public User authenticateUser(User u) {
    	User temp = userDao.getUserById(u.getEmail());
    	if (temp == null) {
    		return null;
    	}else {
    		if (temp.getPassword().equals(u.getPassword())) {
    			System.out.println(temp.getFirstname());
    			return temp;
    		}
    	}
		return null;
    }

}