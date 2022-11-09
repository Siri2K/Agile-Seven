package com.demo.server.Repository;

import com.demo.server.model.Items;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemsRepository extends JpaRepository<Items,Integer>
{
    
}
