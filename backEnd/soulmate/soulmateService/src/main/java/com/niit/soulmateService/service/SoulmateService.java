package com.niit.soulmateService.service;

import com.niit.soulmateService.exception.UserAlreadyExistsException;
import com.niit.soulmateService.exception.UserNotRegisteredException;
import com.niit.soulmateService.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SoulmateService {
    public User registerUser(User user) throws UserAlreadyExistsException;
//    public User registerImage(User user, MultipartFile file);

//    User registerImage(String userEmail, MultipartFile file);

    User registerImage(String userEmail, MultipartFile file) throws IOException;

    public List<User> getAllUsers();
    public boolean deleteUser(String Email) throws UserNotRegisteredException;
}

