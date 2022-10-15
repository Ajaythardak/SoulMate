package com.niit.userService.security;


import com.niit.userService.domain.User;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(User user);

//    Map<String, String> generateToKen(User user);
}
