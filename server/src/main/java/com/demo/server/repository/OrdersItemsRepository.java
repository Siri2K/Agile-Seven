package com.demo.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.server.model.OrdersItems;

public interface OrdersItemsRepository extends JpaRepository<OrdersItems,Integer> {
    
}
