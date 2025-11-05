package com.project.myproject.services;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
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

  
  private static final PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

  public void saveNewUser(User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    user.setRole(Arrays.asList("user"));
    userRepository.save(user);
  }
  public void saveEntry(User user){
    userRepository.save(user);
  }
 public List<User> getAll(){return userRepository.findAll();}

 public Optional<User> findbyId(ObjectId id){
  return userRepository.findById(id);
 }
 public void deleteById(ObjectId id){
  userRepository.deleteById(id);
 }
public User findbyUserName(String userName){
  return userRepository.findByUserName(userName);
}
}
