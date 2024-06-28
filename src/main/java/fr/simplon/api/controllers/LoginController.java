package fr.simplon.api.controllers;

import java.util.InputMismatchException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.simplon.api.Exception.InvalidCredentialException;
import fr.simplon.api.models.User;
import fr.simplon.api.repositories.UserRepository;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public User login(
            @ModelAttribute("username") String username,
            @ModelAttribute("password") String password
    ) throws InvalidCredentialException {
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(
                () -> new InvalidCredentialException("Check your credentials")
                // () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED)
        );
    }

    @PostMapping("/register")
    public User createUser(
        @ModelAttribute("username") String username,
        @ModelAttribute("password") String password,
        @ModelAttribute("passwordConfirm") String passwordConfirm,
        @ModelAttribute("email") String email
    ) {
        if (password.equals(passwordConfirm)) {
            User user = new User(username);
            user.setEmail(email);
            user.setPassword(password);
            return userRepository.save(user);
        } else {
            throw new InputMismatchException("Passwords didn't match");
        }
    }

}
