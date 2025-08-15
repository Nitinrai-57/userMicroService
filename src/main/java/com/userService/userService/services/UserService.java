package com.userService.userService.services;

import com.userService.userService.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    User getUser(String userId);
    List<User> getAllUser();

}
