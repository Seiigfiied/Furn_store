package com.chesnakov.hardwareecommerce.controller;

import com.chesnakov.hardwareecommerce.entity.User;
import com.chesnakov.hardwareecommerce.service.UserService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@CrossOrigin(origins = "http://46.253.143.107:4200")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin() {
        return "This URL is only accessible for admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasAnyRole('Admin', 'User')")
    public String forUser() {
        return "This URL is only accessible for user";
    }

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUser();
    }
}
