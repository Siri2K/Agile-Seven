package com.demo.server.Repository;

// Import Model
import com.demo.server.model.User;

// Import Java Packages
import org.springframework.data.jpa.repository.JpaRepository;


// Setup Data Access
public interface UserRepository extends JpaRepository<User,Integer>
{
    User findbyEmailAndPassword(String email, String password);
}