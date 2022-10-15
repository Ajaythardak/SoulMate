package com.niit.userService.service;

import com.niit.userService.domain.User;
import com.niit.userService.exception.UserNotFoundException;

public interface UserService
{
    public User saveUser(User user);
    public User loginUser(String emailId,String password) throws UserNotFoundException;
}

