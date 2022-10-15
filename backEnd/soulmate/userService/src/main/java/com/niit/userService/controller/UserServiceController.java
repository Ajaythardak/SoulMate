package com.niit.userService.controller;

import com.niit.userService.domain.User;
import com.niit.userService.exception.UserNotFoundException;
import com.niit.userService.security.SecurityTokenGenerator;
import com.niit.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin("*")
@RequestMapping("/User")
public class UserServiceController {
    UserService userService;
    SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserServiceController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {
        Map<String,String> map = null;
        try {
            User user1 = userService.loginUser(user.getEmailId(),user.getPassword());
            if(user1.getEmailId().equalsIgnoreCase(user.getEmailId())) {
                map = securityTokenGenerator.generateToken(user);
            }
            return new ResponseEntity<>(map, HttpStatus.OK);
        }catch (UserNotFoundException e){
            e.printStackTrace();
            throw new UserNotFoundException();
        }
    }
}