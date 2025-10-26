package com.project.myproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.myproject.entity.User;

public interface UserRepository extends MongoRepository<User, Object>{
  User findByUserName(String username);

}
