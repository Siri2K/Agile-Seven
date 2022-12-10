package com.demo.server.controller;

// Import Classes
import com.demo.server.service.OrderService;
import com.demo.server.service.UsersService;
import com.demo.server.common.ApiResponse;
import com.demo.server.model.Users;
import com.demo.server.model.Orders;

// Import Java and Spring Packages
import java.util.Objects;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/order")
public class OrderController 
{
    @Autowired
    private OrderService orderService;

    /* 
    @Autowired
    private UsersService userService;
    */

    @Autowired // Repository that will handle the data
    public OrderController(OrderService orderService) 
    {
        this.orderService = orderService;
    }

    @GetMapping(path = "/")
    public String listOrders(Model model)
    {
        model.addAttribute("allOrders", orderService.findAll());
        return "order";   
    }

    @GetMapping(path = "/order/delete/{id}")
    public String deleteOrder(@PathVariable(value = "id") Integer id)
    {
        orderService.deleteById(id);
        return "redirect:/";
    }
    
    
}
