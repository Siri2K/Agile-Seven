package com.demo.server.service;

// Import Classes
import com.demo.server.model.User;
import com.demo.server.repository.UserRepository;

// Import JAva and Spring Classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public User login(String email, String password)
    {
        User user = userRepository.findByEmailAndPassword(email,password);
        return user;
    }
}