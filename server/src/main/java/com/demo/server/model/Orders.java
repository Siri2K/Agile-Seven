package com.demo.server.model;

// Imports to Model Class
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Class Generates Table Model
@Entity
public class Orders {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    
    private Integer user_id;
    private String created_date;
    private int total_price;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
   
    public String getCreated_date() {
        return created_date;
    }
    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }
   
    public int getTotal_price() {
        return total_price;
    }
    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Orders [id=" + id + ", user_id=" + user_id + ", created_date=" + created_date + ", total_price="
                + total_price + "]";
    }  
}
