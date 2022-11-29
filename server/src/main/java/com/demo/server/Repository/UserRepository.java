package com.demo.server.repository;

// Import Model
import com.demo.server.model.User;

// Import Java and Spring Packages
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Setup Data Access
@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
    User findByEmailAndPassword(String email, String password);
}