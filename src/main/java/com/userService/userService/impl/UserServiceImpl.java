package com.userService.userService.impl;

import com.userService.userService.entities.User;
import com.userService.userService.exception.ResourceNotFount;
import com.userService.userService.repositories.UserRepository;
import com.userService.userService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public User saveUser(User user) {
        String id=UUID.randomUUID().toString();
        user.setUserId(id);
      return userRepository.save(user);

    }

    @Override
   public User getUser(String userId)
    {
        return userRepository.findById(userId).orElseThrow(()->new ResourceNotFount("User is not found"));
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
