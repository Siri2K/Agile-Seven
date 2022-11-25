package com.demo.server.model;

// Imports to Model Class
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Class Generates Table Model
@Entity
public class OrdersItems {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer order_item_id;
    
    private Integer product_id; 
    private Integer order_id;
    private String date;
    private int quantity;
    private double price;

    public Integer getOrder_item_id() {
        return order_item_id;
    }
    public void setOrder_item_id(Integer order_item_id) {
        this.order_item_id = order_item_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
    
    public Integer getOrder_id() {
        return order_id;
    }
    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }
    
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "OrdersItems [order_item_id=" + order_item_id + ", product_id=" + product_id + ", order_id=" + order_id
                + ", date=" + date + ", quantity=" + quantity + ", price=" + price + "]";
    }
}
