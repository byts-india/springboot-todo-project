package com.project.todo.user;

import com.project.todo.user.dto.UserPasswordUpdateDTO;
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

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("")
    public String createNew(@RequestBody User newUser) {
        try {
            userService.addNewUser(newUser);
            return "new user created";
        } catch (Exception e) {
            return "something went wrong" + e.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return "deleted successfully.";
        } catch (Exception e) {
            return "something went wrong" + e.getMessage();
        }
    }

    @PutMapping("")
    public String update(@RequestBody UserPasswordUpdateDTO payload) {
        try {
            Long id = payload.getId();
            String newPassword = payload.getPassword();
            userService.updateUserPassword(id, newPassword);
            return "updated successfully";
        } catch (Exception e) {
            return "something went wrong: " + e.getMessage();
        }
    }
}
