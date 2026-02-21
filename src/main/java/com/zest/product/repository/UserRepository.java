package com.zest.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.zest.product.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}