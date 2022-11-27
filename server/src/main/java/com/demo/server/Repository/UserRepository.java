package com.demo.server.repository;

// Import Model
import com.demo.server.model.User;

// Import Java Packages
import org.springframework.data.jpa.repository.JpaRepository;

// Setup Data Access
public interface UserRepository extends JpaRepository<User,Integer>
{
    User findByEmailAndPassword(String email, String password);
}