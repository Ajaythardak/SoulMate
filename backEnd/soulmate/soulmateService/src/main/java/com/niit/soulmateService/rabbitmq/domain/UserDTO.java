package com.niit.soulmateService.rabbitmq.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class UserDTO {
    private String name;
    private int age;
    private String gender;
    private String city;
    private String emailId;
    private String password;
    private byte[] image;
}