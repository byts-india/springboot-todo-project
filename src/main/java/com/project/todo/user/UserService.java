package com.project.todo.user;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
    	this.userRepo = userRepo;
    }
    // used to insert dummy data
    public void seed() {
            User u1 = new User();
            u1.setEmail("tom@gmail.com");
            u1.setPassword("jerryIsFriend");

            User u2 = new User();
            u2.setEmail("bheem@gmail.com");
            u2.setPassword("chutki123");
            
            User u3 = new User();
            u3.setEmail("sakthiman@gmail.com");
            u3.setPassword("password");

            userRepo.deleteAll();
            userRepo.saveAll(List.of(u1,u2,u3));
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
