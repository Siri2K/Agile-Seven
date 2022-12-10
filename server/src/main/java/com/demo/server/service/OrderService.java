package com.demo.server.service;

// Import Classes
import com.demo.server.repository.OrdersRepository;
import com.demo.server.model.Orders;
import com.demo.server.model.OrdersItems;
import com.demo.server.model.Users;
import com.demo.server.repository.OrdersItemsRepository;

// Import Java and Spring Package
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Transactional
public class OrderService 
{
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    OrdersItemsRepository ordersItemsRepository;

    public void placeOrder(Users user)
    {
        // Create New Order and Save it
        Orders newOrder = new Orders();
        OrdersItems newOrderItems = new OrdersItems();
        newOrder.setCreatedDate(new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
        newOrder.setUser(user);
        newOrder.setTotalPrice(newOrderItems.getPrice());
        ordersRepository.save(newOrder);
    }

    /* 
    public List<Orders> listOrders(@PathVariable("created_date") Users user)
    {
        return ordersRepository.findAllByUserOrderByCreated_dateDesc(user);
        
    }
    */

    public Orders getOrder(Integer orderId)
    {
        Optional<Orders> order = ordersRepository.findById(orderId);
        if(order.isPresent())
        {
            return order.get();
        }
        return null;
    }

    public List<Orders> findAll() 
    {
        return ordersRepository.findAll();
    }

    public @ResponseBody void deleteById(@RequestParam("id") Integer id)
    {
        ordersRepository.deleteById(id);
    }
}
