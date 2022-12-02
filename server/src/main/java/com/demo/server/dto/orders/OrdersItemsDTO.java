package com.demo.server.dto.orders;

public class OrdersItemsDTO 
{
    // Instances
    private Double price;
    private Integer quantity, orderId, productId;

    // Constructor
    public OrdersItemsDTO() 
    {

    }


    public OrdersItemsDTO(Double price, Integer quantity, Integer orderId, Integer productId) 
    {
        this.price = price;
        this.quantity = quantity;
        this.orderId = orderId;
        this.productId = productId;
    }

    // Set & Get
    public Double getPrice() 
    {
        return this.price;
    }

    public void setPrice(Double price) 
    {
        this.price = price;
    }

    public Integer getQuantity() 
    {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) 
    {
        this.quantity = quantity;
    }

    public Integer getOrderId() 
    {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) 
    {
        this.orderId = orderId;
    }

    public Integer getProductId() 
    {
        return this.productId;
    }

    public void setProductId(Integer productId) 
    {
        this.productId = productId;
    }

    
}
