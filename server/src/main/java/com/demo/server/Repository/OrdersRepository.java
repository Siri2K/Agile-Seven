package com.demo.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.server.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    
}
