package com.demo.server.repository;

// Import Classes
import com.demo.server.model.OrdersItems;

// Import Spring and Java Packages
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersItemsRepository extends JpaRepository<OrdersItems,Integer> 
{
    
}
