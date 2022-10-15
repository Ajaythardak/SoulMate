package com.niit.soulmateService.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
@NoArgsConstructor
public class User {

    @Transient
    public static final String SEQUENCE_NAME="user_sequence";

    private String name;
    private int age;
    private String gender;
    private String city;
    @Id
    private String emailId;
    @Value("${db.password}")
    private String password;
//    private MultipartFile picture;
    private byte[] image;


}

