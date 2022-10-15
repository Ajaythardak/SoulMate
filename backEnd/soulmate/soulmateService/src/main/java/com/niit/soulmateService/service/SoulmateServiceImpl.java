package com.niit.soulmateService.service;

import com.niit.soulmateService.config.Producer;
import com.niit.soulmateService.exception.UserAlreadyExistsException;
import com.niit.soulmateService.exception.UserNotRegisteredException;
import com.niit.soulmateService.model.User;
import com.niit.soulmateService.rabbitmq.domain.UserDTO;
import com.niit.soulmateService.repository.SoulmateServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class SoulmateServiceImpl implements SoulmateService{

    private SoulmateServiceRepository soulmateServiceRepository;

    @Autowired
    public Producer producer;

    @Autowired
    public SoulmateServiceImpl(SoulmateServiceRepository soulmateServiceRepository) {
        this.soulmateServiceRepository = soulmateServiceRepository;
    }


    @Override
    public User registerUser(User user) throws UserAlreadyExistsException {
        UserDTO userDTO = new UserDTO();

        userDTO.setName(user.getName());
        userDTO.setAge(user.getAge());
        userDTO.setGender(user.getGender());
        userDTO.setCity(user.getCity());
        userDTO.setEmailId(user.getEmailId());
        userDTO.setPassword(user.getPassword());
        userDTO.setImage(user.getImage());

        if(soulmateServiceRepository.findById(user.getEmailId()).isPresent()){
            throw new UserAlreadyExistsException();
        }else {
            soulmateServiceRepository.save(user);
            producer.sendMessageToRabbitMq(userDTO);
            return user;
        }
    }

    @Override
    public User registerImage(String userEmail, MultipartFile file) throws IOException {
        User user = soulmateServiceRepository.findById(userEmail).get();
            user.setImage(file.getBytes());
            soulmateServiceRepository.save(user);
            return user;
    }
    @Override
    public List<User> getAllUsers() {
        return soulmateServiceRepository.findAll();
    }

    @Override
    public boolean deleteUser(String Email) throws UserNotRegisteredException {
        User user = soulmateServiceRepository.findById(Email).get();
        if(soulmateServiceRepository.findById(user.getEmailId()).isPresent()){
            soulmateServiceRepository.delete(user);
            return true;
        }else {
            throw new UserNotRegisteredException();
        }
    }
}
