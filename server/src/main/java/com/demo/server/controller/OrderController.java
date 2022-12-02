package com.demo.server.controller;

// Import Classes
import com.demo.server.service.OrderService;
import com.demo.server.service.UserService;
import com.demo.server.common.ApiResponse;
import com.demo.server.model.User;
import com.demo.server.model.Orders;

// Import Java and Spring Packages
import java.util.Objects;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/order")
public class OrderController 
{
    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    // Place Order
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> placeOrder(User user)
    {   
        User oauthUser = userService.login(user.getEmail(), user.getPassword());

        if(Objects.nonNull(oauthUser))
        {
            orderService.placeOrder(user);
            return new ResponseEntity<>(new ApiResponse(true, "Order has been placed"), HttpStatus.CREATED);
        } 
        return null;
    }

    // Get all Order
    @GetMapping("/")
    public ResponseEntity<List<Orders>> getAllOrder(User user)
    {   
        User oauthUser = userService.login(user.getEmail(), user.getPassword());

        if(Objects.nonNull(oauthUser))
        {
            List<Orders> ordersDTOList = orderService.listOrders(user);
            return new ResponseEntity<>(ordersDTOList,HttpStatus.OK);
        } 
        return null;
    }

    // Get Specific Order
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderbyId(@PathVariable("id") Integer id, User user)
    {   
        User oauthUser = userService.login(user.getEmail(), user.getPassword());

        if(Objects.nonNull(oauthUser))
        {
            Orders order = orderService.getOrder(id);
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(new Exception().getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
