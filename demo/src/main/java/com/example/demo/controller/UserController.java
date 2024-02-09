package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/")
  public ResponseEntity<List<User>> findAllUsers() {
    try {
      return ResponseEntity.ok(userService.findAllUsers());
    } catch (Exception e) {
      return ResponseEntity.status(Response.SC_INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @PostMapping("/")
  public String createUser(@RequestBody User entity) {
    try {
      userService.createUser(entity);
      return "User created successfully";
    } catch (Exception e) {
      return "Error creating user: " + e.getMessage();
    }
  }
  
  
}
