package com.niit.soulmateService.controller;

import com.niit.soulmateService.exception.UserAlreadyExistsException;
import com.niit.soulmateService.exception.UserNotRegisteredException;
import com.niit.soulmateService.model.User;
import com.niit.soulmateService.service.SoulmateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/UserInfo")
public class SoulmateServiceController {


    SoulmateService soulmateService;

    @Autowired
    public SoulmateServiceController(SoulmateService soulmateService) {
        this.soulmateService = soulmateService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) throws UserAlreadyExistsException {
//        User user1 = soulmateService.registerUser(user);
        return soulmateService.registerUser(user);
//          soulmateService.registerImage(user.getEmailId(),user.getImage());
    }

    @PostMapping("/registerImage/{emailId}")
    public User registerImage(@PathVariable String emailId, MultipartFile file) throws IOException {
//        User user1 = soulmateService.registerUser(user);
        return soulmateService.registerImage(emailId,file);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(soulmateService.getAllUsers(), HttpStatus.OK);
    }

    @DeleteMapping("/user/{userEmail}")
    public ResponseEntity<?> deleteUser(@PathVariable String userEmail) throws Exception {
        try {
            if (soulmateService.deleteUser(userEmail))
                return new ResponseEntity<>("User Deleted", HttpStatus.OK);
            else
                return new ResponseEntity<>("User Not Deleted", HttpStatus.OK);
        } catch (UserNotRegisteredException e) {
            e.getMessage();
            throw new Exception();
        }
    }
}