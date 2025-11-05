package com.project.myproject.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.project.myproject.entity.User;
import com.project.myproject.repository.UserRepository;

@Component
public class UserService {
  @Autowired
  private UserRepository userRepository;

  private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  public Boolean saveNewUser(User user) {
    try {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setRole(Arrays.asList("user"));
      userRepository.save(user);
      return true;

    } catch (Exception e) {
      logger.info("heheheh");
      return false;

    }

  }

  public void saveUser(User user) {
    userRepository.save(user);
  }

  public List<User> getAll() {
    return userRepository.findAll();
  }

  public Optional<User> findbyId(ObjectId id) {
    return userRepository.findById(id);
  }

  public void deleteById(ObjectId id) {
    userRepository.deleteById(id);
  }

  public User findbyUserName(String userName) {
    return userRepository.findByUserName(userName);
  }
}
