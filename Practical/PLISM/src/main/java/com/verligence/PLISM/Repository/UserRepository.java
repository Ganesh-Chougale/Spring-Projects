package com.verligence.PLISM.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.verligence.PLISM.Entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}