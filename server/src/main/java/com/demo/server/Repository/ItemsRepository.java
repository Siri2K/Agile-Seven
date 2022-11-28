package com.demo.server.repository;

// Import Model
import com.demo.server.model.Items;

// Import Java Packages
import org.springframework.data.jpa.repository.JpaRepository;

// Setup Data Access
public interface ItemsRepository extends JpaRepository<Items,Integer>
{
    
}
