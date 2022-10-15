package com.niit.soulmateService.repository;

import com.niit.soulmateService.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SoulmateServiceRepository extends MongoRepository<User,String> {
}
