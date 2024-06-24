package fr.simplon.api.controllers;

import fr.simplon.api.models.User;
import org.springframework.stereotype.Controller;

@Controller
public class UserController{
    @GetMapping("/users")
    public User[] getUserList(){

        return new Users[]{new User()};

    @PostMapping("/user")
    public User createUser(User user){
        return new User();
    }

    @GetMapping("/hello/:username")
    public String hello(String username){
        return "Hello,  "+ username;
    }
}
