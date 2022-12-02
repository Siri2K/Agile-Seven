package com.demo.server.repository;

// Import Classes
import com.demo.server.model.Orders;
import com.demo.server.model.User;

// Import Spring and Java packages
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> 
{
    List<Orders> findAllByUserOrderByCreatedDateDesc(User user);
}
