package com.codetech.users_crud.infrastructure.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codetech.users_crud.infrastructure.entities.User;

import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> FindByEmail(String email);
    @Transactional
    void DeleteByEmail(String email);
}
