package com.niit.userService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "USer Already Registered")
public class UserAlreadyThereException extends Exception {
}
