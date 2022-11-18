package com.demo.server.Repository;

// Import Model
import com.demo.server.model.User;

// Import Java Packages
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


// Setup Data Access
public interface UserRepository extends JpaRepository<User,Integer>
{
    Optional<User> findbyUserName(String username);
    Boolean existsbyUserName(String username);
    Boolean existsbyEmail(String email);
}