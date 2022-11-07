package com.demo.server.model;

// Imports to Model Class
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Class Generates Table Model
@Entity 
public class Items
{
    // Items Columns
    private Integer quantity_on_stock;
    private String name,description;
    private Double price;

    // Items Primary Key Column
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer product_ID;

    // Constructors
    public Items() {}

    public Items(Integer product_ID, Integer quantity_on_stock, String name, String description, Double price) 
    {
        this.product_ID = product_ID;
        this.quantity_on_stock = quantity_on_stock;
        this.name = name;
        this.description = description;
        this.price = price;
    }
    

    // Setters & Getters
    public Integer getProduct_ID() 
    {
        return this.product_ID;
    }

    public void setProduct_ID(Integer product_ID) 
    {
        this.product_ID = product_ID;
    }

    public Integer getQuantity_on_stock() 
    {
        return this.quantity_on_stock;
    }

    public void setQuantity_on_stock(Integer quantity_on_stock) 
    {
        this.quantity_on_stock = quantity_on_stock;
    }

    public String getName() 
    {
        return this.name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getDescription() 
    {
        return this.description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public Double getPrice() 
    {
        return this.price;
    }

    public void setPrice(Double price) 
    {
        this.price = price;
    }
    

    @Override
    public String toString() 
    {
        return "{" +
            " product_ID='" + getProduct_ID() + "'" +
            ", quantity_on_stock='" + getQuantity_on_stock() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

}
