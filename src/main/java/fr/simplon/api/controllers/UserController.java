package fr.simplon.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.api.models.User;
import fr.simplon.api.repositories.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(
            @ModelAttribute("username") String username,
            @ModelAttribute("name") String name,
            @ModelAttribute("email") String email,
            @ModelAttribute("password") String password

            ){
        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }
    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable("userId") Integer userId) {
        return userRepository.findById(userId);
    }

}