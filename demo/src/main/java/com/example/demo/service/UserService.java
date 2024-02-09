package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;


  public List<User> findAllUsers() {
    try {
      return userRepository.findAll();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public User findUserById(Long id) {
    try {
      User existingUser = userRepository.findById(id).orElseThrow(() -> new Exception("User not found with id: " + id));

      User user = new User();
      user.setId(existingUser.getId());
      user.setUsername(existingUser.getUsername());
      user.setPassword(existingUser.getPassword());
      user.setEmail(existingUser.getEmail());
      return user;
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public User createUser(User user) {
    try {
      User newUser = new User();
      newUser.setUsername(user.getUsername());
      newUser.setPassword(user.getPassword());
      newUser.setEmail(user.getEmail());
      return userRepository.save(newUser);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public User updateUser(User user) {
    try {
      User existingUser = userRepository.findById(user.getId()).orElseThrow(() -> new Exception("User not found with id: " + user.getId()));

      existingUser.setUsername(user.getUsername());
      existingUser.setPassword(user.getPassword());
      existingUser.setEmail(user.getEmail());
      return userRepository.save(existingUser);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }
  }
}
