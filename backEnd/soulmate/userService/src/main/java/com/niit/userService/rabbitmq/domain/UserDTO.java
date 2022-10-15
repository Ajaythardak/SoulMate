package com.niit.userService.rabbitmq.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private String emailId;
    private String password;
}
