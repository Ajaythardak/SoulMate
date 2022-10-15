package com.niit.userService.service;

import com.niit.userService.domain.User;
import com.niit.userService.exception.UserNotFoundException;
import com.niit.userService.repository.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    UserServiceRepository userServiceRepository;

    @Autowired
    public UserServiceImpl(UserServiceRepository userServiceRepository) {
        this.userServiceRepository = userServiceRepository;
    }

    @Override
    public User saveUser(User user) {
        return userServiceRepository.save(user);
    }

    @Override
    public User loginUser(String emailId, String password) throws UserNotFoundException {
        User user = userServiceRepository.findByEmailIdAndPassword(emailId, password);
        if (user == null) {
            throw new UserNotFoundException();
        } else {
            return user;
        }
    }
}
