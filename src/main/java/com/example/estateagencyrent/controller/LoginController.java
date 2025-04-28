package com.example.estateagencyrent.controller;

import com.example.estateagencyrent.entity.User;
import com.example.estateagencyrent.entity.UserUpdate;
import com.example.estateagencyrent.service.LoginService;
import com.example.estateagencyrent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User login(Authentication authentication) {
        Optional<User> user = userService.findUserByUsername(authentication.getName());
        return user.orElse(null);
    }

    @PostMapping("/signUp")
    public ResponseEntity<String> signUp(@RequestBody User user) {
        if (loginService.signUp(user)) {
            return new ResponseEntity<>("Sign up successfully!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/changePw")
    public ResponseEntity<String> changePassword(@RequestBody UserUpdate userUpdate) {
        if (loginService.changePassword(userUpdate)) {
            return new ResponseEntity<>("Change password successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
