package com.project.myproject.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.myproject.entity.User;
import com.project.myproject.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @PutMapping
  public ResponseEntity<?> updateUser(@RequestBody User user) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userName = authentication.getName();
    User userInDb = userService.findbyUserName(userName);
    userInDb.setUserName(user.getUserName());
    userInDb.setPassword(user.getPassword());
    userService.saveNewUser(userInDb);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

@GetMapping
  public ResponseEntity<?> greeting(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    return new ResponseEntity<>("hi"+authentication.getName(), HttpStatus.OK);
  }

  
}
