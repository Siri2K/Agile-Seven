package com.demo.server.repository;

// Import Model
import com.demo.server.model.Items;

// Import Java and Spring Packages
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Setup Data Access
@Repository
public interface ItemsRepository extends JpaRepository<Items,Integer>
{    
    // Find all
    @Override
    List<Items> findAll();
    
    // Sort Price 
    @Query("FROM items ORDER BY price ASC")
    List<Items> findByOrderByPriceAsc();

    @Query("FROM items ORDER BY price DESC")
    List<Items> findByOrderByPriceDesc();
    
}
