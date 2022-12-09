package com.demo.server.model;

// Imports to Java and Spring Packages
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

// Class Generates Table Model
@Entity
@Table(name = "items")
public class Items
{
    // Items Columns
    private Integer quantity_on_stock;
    private String name,description;
    private Double price;

    // Items Image Column
    @Lob
    private byte[] picture;

    // Items Primary Key Column
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    // Constructors
    public Items() {}

    public Items(Integer id, Integer quantity_on_stock, String name, String description, Double price, byte[] picture) 
    {
        this.id = id;
        this.quantity_on_stock = quantity_on_stock;
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
    }
    

    // Setters & Getters
    public Integer getId() 
    {
        return this.id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
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

    public byte[] getPicture() 
    { 
        return this.picture;
    }

    public void setPicture(byte[] picture) 
    {
        this.picture = picture;
    }


    @Override
    public String toString() 
    {
        return "{" +
            " id='" + getId() + "'" +    
            ", quantity_on_stock='" + getQuantity_on_stock() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", price='" + getPrice() + "'" +
            ", picture='" + getPicture() + "'" +
            "}";
    }


}
