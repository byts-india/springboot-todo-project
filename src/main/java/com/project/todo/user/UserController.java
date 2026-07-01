package com.project.todo.user;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
    	this.userService = userService;
    }

    @PostMapping("/init")
    public String init() {
    	userService.seed();
    	return "initiated with dummy values in table";
    }

    @GetMapping("/all")
    public List<User> getAll() {
    	return userService.getAllUsers();
    }
}
