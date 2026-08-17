package com.youmanscode.jobapplicationtrackerapi.controller;

import com.youmanscode.jobapplicationtrackerapi.entity.User;

import com.youmanscode.jobapplicationtrackerapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("createUser")
    public User saveNewUser(@RequestBody @Valid User user) {
        return userService.saveNewUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
