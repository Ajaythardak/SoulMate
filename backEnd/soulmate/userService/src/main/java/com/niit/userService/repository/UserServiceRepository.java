package com.niit.userService.repository;

import com.niit.userService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceRepository extends JpaRepository <User,String> {

    public User findByEmailIdAndPassword (String emailId , String password);

}
