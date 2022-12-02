package com.demo.server.service;

// Import Classes
import com.demo.server.repository.OrdersRepository;
import com.demo.server.model.Orders;
import com.demo.server.model.OrdersItems;
import com.demo.server.model.User;
import com.demo.server.repository.OrdersItemsRepository;

// Import Java and Spring Package
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService 
{
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrdersItemsRepository ordersItemsRepository;

    public void placeOrder(User user)
    {
        // Create New Order and Save it
        Orders newOrder = new Orders();
        OrdersItems newOrderItems = new OrdersItems();
        newOrder.setCreatedDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
        newOrder.setUser(user);
        newOrder.setTotalPrice(newOrderItems.getPrice());
        ordersRepository.save(newOrder);
    }

    public List<Orders> listOrders(User user)
    {
        return ordersRepository.findAllByUserOrderByCreatedDateDesc(user);
    }

    public Orders getOrder(Integer orderId)
    {
        Optional<Orders> order = ordersRepository.findById(orderId);
        if(order.isPresent())
        {
            return order.get();
        }
        return null;
    }
}
