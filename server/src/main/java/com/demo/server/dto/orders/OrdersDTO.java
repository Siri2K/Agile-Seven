package com.demo.server.dto.orders;

// Import Classes
import com.demo.server.model.Orders;

// Import Java and Spring Packages



public class OrdersDTO 
{
    // Instances
    private Integer Id;
    private Integer user_id;

    // Constructor
    public OrdersDTO() 
    {
    }

    public OrdersDTO(Orders order) 
    {
        this.setId(order.getId());
        this.setUserId(order.getUserId());
    }

    // Set & Get
    public Integer getId() 
    {
        return this.Id;
    }

    public void setId(Integer Id) 
    {
        this.Id = Id;
    }

    public Integer getUserId() 
    {
        return this.user_id;
    }

    public void setUserId(Integer user_id) 
    {
        this.user_id = user_id;
    }


}
