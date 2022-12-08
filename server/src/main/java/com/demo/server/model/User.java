package com.demo.server.model;

// Imports to Model Class
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Class Generates Table Model
@Entity 
public class User 
{
    // Columns 
    private String first_name, last_name, email, role, password;

    // Primary Key
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    // Constructor
    public User() {}


    public User(Integer id, String first_name, String last_name, String email, String role, String password) 
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    // Database Columns
    public Integer getID() 
    {
        return this.id;
    }

    public void setID(Integer id) 
    {
        this.id = id;
    }

    public String getFirst_Name() 
    {
        return this.first_name;
    }

    public void setFirst_Name(String first_name) 
    {
        this.first_name = first_name;
    }

    public String getLast_name() 
    {
        return this.last_name;
    }

    public void setLast_name(String last_name) 
    {
        this.last_name = last_name;
    }

    public String getEmail() 
    {
        return this.email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getRole() 
    {
        return this.role;
    }

    public void setRole(String role) 
    {
        this.role = role;
    }

    public String getPassword() 
    {
        return this.password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }


    @Override
    public String toString() 
    {
        return "{" +
            " first_name='" + getFirst_Name() + "'" +
            ", last_name='" + getLast_name() + "'" +
            ", email='" + getEmail() + "'" +
            ", role='" + getRole() + "'" +
            ", password='" + getPassword() + "'" +
            ", id='" + getID() + "'" +
            "}";
    }
    
}
