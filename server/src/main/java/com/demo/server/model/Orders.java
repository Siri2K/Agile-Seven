package com.demo.server.model;

// Imports to Java Class
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// Class Generates Table Model
@Entity
@Table(name = "orders")
public class Orders 
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;
    
    private Integer user_id;
    private String created_date;
    private Double total_price;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrdersItems> ordersItems;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Users user;

    // Constructor
    public Orders() 
    {
    }

    // Set & Get Function
    public Integer getId() 
    {
        return this.id;
    }

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getUserId() 
    {
        return this.user_id;
    }

    public void setUserId(Integer user_id) 
    {
        this.user_id = user_id;
    }

    public String getCreatedDate() 
    {
        return this.created_date;
    }

    public void setCreatedDate(String created_date) 
    {
        this.created_date = created_date;
    }

    public Double getTotalPrice() 
    {
        return this.total_price;
    }

    public void setTotalPrice(Double total_price) 
    {
        this.total_price = total_price;
    }

    public List<OrdersItems> getOrdersItems() 
    {
        return this.ordersItems;
    }

    public void setOrdersItems(List<OrdersItems> ordersItems) 
    {
        this.ordersItems = ordersItems;
    }

    public Users getUser() 
    {
        return this.user;
    }

    public void setUser(Users user) 
    {
        this.user = user;
    }
}
