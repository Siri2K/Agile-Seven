package com.demo.server.service;

// Import Classes
import com.demo.server.model.Users;
import com.demo.server.repository.UsersRepository;

// Import SpringBoot and Java Packages
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService 
{
    @Autowired
    private UsersRepository repo;
  
    public Users login(String email, String password) 
    {
        Users user = repo.findByEmailAndPassword(email, password);
        return user;
    }
}
