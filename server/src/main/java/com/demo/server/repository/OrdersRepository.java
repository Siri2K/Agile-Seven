package com.demo.server.repository;

// Import Classes
import com.demo.server.model.Orders;
import com.demo.server.model.Users;

// Import Spring and Java packages
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer> 
{
    @Query(value = "SELECT * FROM orders h where h.created_date = :created_date", nativeQuery = true)
    List<Orders> findAllByUserOrderByCreated_dateDesc(@Param("created_date") Users user);   
}
