package com.demo.server.model;

import java.sql.Blob;

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
    private Blob photo;

    // Items Primary Key Column
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer ID;

    // Constructors
    public Items() {}

    public Items(Integer ID, Integer quantity_on_stock, String name, String description, Double price, Blob photo) 
    {
        this.ID = ID;
        this.quantity_on_stock = quantity_on_stock;
        this.name = name;
        this.description = description;
        this.price = price;
        this.photo = photo;
    }
    

    // Setters & Getters
    public Integer getID() 
    {
        return this.ID;
    }

    public void setID(Integer ID) 
    {
        this.ID = ID;
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

    public Blob getPhoto() 
    { 
        return this.photo;
    }

    public void setPhoto(Blob photo) 
    {
        this.photo = photo;
    }
    

    @Override
    public String toString() 
    {
        return "{" +
            " ID='" + getID() + "'" +
            ", quantity_on_stock='" + getQuantity_on_stock() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

}
