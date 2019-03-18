package com.ex.dao;

import com.ex.model.User;

public interface IUserDao {

    User getUserById(int userId);
    User getUserByEmail(String email);
}
