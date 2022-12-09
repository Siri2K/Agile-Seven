package com.demo.server.service;

// Import Classes
import com.demo.server.repository.OrdersItemsRepository;
import com.demo.server.model.OrdersItems;

// Import Java and Spring Packages
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class OrderItemsService 
{
    @Autowired
    private OrdersItemsRepository ordersItemsRepository;

    public void addOrderedProduct(OrdersItems orderItems)
    {
        ordersItemsRepository.save(orderItems);
    }
}
