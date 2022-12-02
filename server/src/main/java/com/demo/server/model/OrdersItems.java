package com.demo.server.model;

import java.text.SimpleDateFormat;
import java.util.Date;

// Imports to Model Class
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

// Class Generates Table Model
@Entity
public class OrdersItems 
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer order_item_id;
    
    private Integer product_id; 
    private Integer order_id;
    private String date;
    private int quantity;
    private double price;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Orders order;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Items items;

    // Constructor
    public OrdersItems() 
    {
    }


    public OrdersItems(Orders order, Items items, Integer quantity, Double price) 
    {
        this.items = items;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.date = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
    }

    // Set & Get 
    public Integer getOrderItemId() 
    {
        return this.order_item_id;
    }

    public void setOrderItemId(Integer order_item_id) 
    {
        this.order_item_id = order_item_id;
    }

    public Integer getProductId() 
    {
        return this.product_id;
    }

    public void setProductId(Integer product_id) 
    {
        this.product_id = product_id;
    }

    public Integer getOrderId() 
    {
        return this.order_id;
    }

    public void setOrderId(Integer order_id) 
    {
        this.order_id = order_id;
    }

    public String getDate() 
    {
        return this.date;
    }

    public void setDate(String date) 
    {
        this.date = date;
    }

    public int getQuantity() 
    {
        return this.quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    public double getPrice() 
    {
        return this.price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public Orders getOrder() 
    {
        return this.order;
    }

    public void setOrder(Orders order) 
    {
        this.order = order;
    }

    public Items getItems() 
    {
        return this.items;
    }

    public void setItems(Items items) 
    {
        this.items = items;
    }


}
