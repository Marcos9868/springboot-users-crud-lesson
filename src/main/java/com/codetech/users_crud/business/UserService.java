package com.codetech.users_crud.business;

import org.springframework.stereotype.Service;

import com.codetech.users_crud.infrastructure.entities.User;
import com.codetech.users_crud.infrastructure.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository) {
        this.repository = repository;
    }
    public void SaveUser(User user) {
        repository.saveAndFlush(user);
    }
    public User GetUserByEmail(String email) {
        return repository.FindByEmail(email).orElseThrow(() -> new RuntimeException("Email not found"));
    }
    @Transactional
    public void RemoveUserByEmail(String email) {
        repository.DeleteByEmail(email);
    }
    public void UpdateUserByEmail(String email, User user) {
        User userEntity = GetUserByEmail(email);
        User updatedUser = User
            .builder()
            .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
            .name(user.getName() != null ? user.getName() : userEntity.getName())
            .id(user.getId())
            .build();

        repository.saveAndFlush(updatedUser);
    }
}
