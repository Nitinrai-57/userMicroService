package com.userService.userService.controllers;

import com.userService.userService.entities.User;
import com.userService.userService.services.UserService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("{userId}")
    ResponseEntity<User> getUser(@PathParam("userId") String userId)
    {
      return new ResponseEntity<User>( userService.getUser(userId), HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<User>> getAllUser(){
     return  new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<User> saveUser(@RequestBody User user)
    {
        System.out.println("DEBUG");
        return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.OK);
    }
}
