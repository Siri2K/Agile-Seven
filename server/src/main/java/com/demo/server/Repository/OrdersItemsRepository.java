package com.demo.server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.server.model.OrdersItems;

public interface OrdersItemsRepository extends JpaRepository<OrdersItems,Integer> {
    
}
