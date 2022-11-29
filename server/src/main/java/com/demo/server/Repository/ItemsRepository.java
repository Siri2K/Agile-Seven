package com.demo.server.Repository;

// Import Model
import com.demo.server.model.Items;

import java.util.List;
// Import Java Packages
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Setup Data Access
@Repository
public interface ItemsRepository extends JpaRepository<Items,Integer>
{
    @Override
    List<Items> findAll();
}
