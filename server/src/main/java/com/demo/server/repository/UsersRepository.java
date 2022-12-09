package com.demo.server.repository;

// Import Model
import com.demo.server.model.Users;

// Import Java and Spring Packages
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


// Setup Data Access
@Repository
public interface UsersRepository extends JpaRepository<Users,Integer>
{
    Users findByEmailAndPassword(String email, String password);
}