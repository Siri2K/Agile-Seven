package com.demo.server.controller;

// Import Classes
import com.demo.server.service.OrderService;
import com.demo.server.model.Orders;

// Import Java and Spring Packages
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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

    @GetMapping(path = "/order")
    // public String listOrders(Model model)
    public @ResponseBody Iterable<Orders> listOrders()
    {
        /* 
        model.addAttribute("allOrders", orderService.findAll());
        return "order";
        */
        return orderService.findAll();
    }

    /* 
    @GetMapping(path = "/order/delete/{id}")
    public String deleteOrder(@PathVariable(value = "id") Integer id)
    {
        orderService.deleteById(id);
        return "redirect:/";
    }
    */
    
}
