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
    private String First_Name, Last_name, Email, Role, Password;

    // Primary Key
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer ID;

    // Constructor
    public User() {}


    public User(Integer ID, String First_Name, String Last_name, String Email, String Role, String Password) 
    {
        this.ID = ID;
        this.First_Name = First_Name;
        this.Last_name = Last_name;
        this.Email = Email;
        this.Role = Role;
        this.Password = Password;
    }

    // Database Columns
    public Integer getID() 
    {
        return this.ID;
    }

    public void setID(Integer ID) 
    {
        this.ID = ID;
    }

    public String getFirst_Name() 
    {
        return this.First_Name;
    }

    public void setFirst_Name(String First_Name) 
    {
        this.First_Name = First_Name;
    }

    public String getLast_name() 
    {
        return this.Last_name;
    }

    public void setLast_name(String Last_name) 
    {
        this.Last_name = Last_name;
    }

    public String getEmail() 
    {
        return this.Email;
    }

    public void setEmail(String Email) 
    {
        this.Email = Email;
    }

    public String getRole() 
    {
        return this.Role;
    }

    public void setRole(String Role) 
    {
        this.Role = Role;
    }

    public String getPassword() 
    {
        return this.Password;
    }

    public void setPassword(String Password) 
    {
        this.Password = Password;
    }


    @Override
    public String toString() 
    {
        return "{" +
            " First_Name='" + getFirst_Name() + "'" +
            ", Last_name='" + getLast_name() + "'" +
            ", Email='" + getEmail() + "'" +
            ", Role='" + getRole() + "'" +
            ", Password='" + getPassword() + "'" +
            ", ID='" + getID() + "'" +
            "}";
    }
    
}
