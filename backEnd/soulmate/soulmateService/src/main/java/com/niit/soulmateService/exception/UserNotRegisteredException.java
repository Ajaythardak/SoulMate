package com.niit.soulmateService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND,reason = "User Not Found \n Want to Register??")
public class UserNotRegisteredException extends Exception {
}
