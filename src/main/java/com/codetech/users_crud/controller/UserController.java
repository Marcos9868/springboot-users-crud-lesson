package com.codetech.users_crud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codetech.users_crud.business.UserService;
import com.codetech.users_crud.infrastructure.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;
    public UserController(UserService service) {
        this.service = service;
    }
    public ResponseEntity<Void> AddUser(@RequestBody User user) {
        service.SaveUser(user);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<User> GetUserByEmail(@RequestParam String email) {
        service.GetUserByEmail(email);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> RemoveUserByEmail(@RequestParam String email) {
        service.RemoveUserByEmail(email);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void> UpdateUserByEmail(@RequestParam String email, @RequestBody User user) {
        service.UpdateUserByEmail(email, user);
        return ResponseEntity.ok().build();
    }
}
