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

    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public void addNewUser(User newUser) {
        userRepo.save(newUser);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public void updateUserPassword(Long id, String newPassword) {
        User existingUser = userRepo.findById(id).orElse(null);
        if(existingUser == null) {
            throw new RuntimeException("user with id not found");
        }
        existingUser.setPassword(newPassword);
        userRepo.save(existingUser);
    }
}
