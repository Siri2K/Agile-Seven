package com.demo.server.repository;

// Import Model
import com.demo.server.model.Items;

// Import Java and Spring Packages
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Setup Data Access
@Repository
public interface ItemsRepository extends JpaRepository<Items,Integer>
{    
    
}
