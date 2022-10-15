package com.niit.userService.config;

import com.niit.userService.domain.User;
import com.niit.userService.rabbitmq.domain.UserDTO;
import com.niit.userService.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    private UserService userService;

    @RabbitListener(queues = "queue1")
    public void sendDataFromRabbitmq(UserDTO userDTO){
        User user=new User();
        user.setEmailId(userDTO.getEmailId());
        user.setPassword(userDTO.getPassword());
        userService.saveUser(user);
    }

}
