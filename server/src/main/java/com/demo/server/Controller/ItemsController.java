package com.demo.server.controller;

// Import Classes 
import com.demo.server.model.Items;
import com.demo.server.repository.ItemsRepository;

// Imports Spring & Java Packages
import java.util.Optional;
import java.sql.Blob;
import java.sql.SQLException;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Set Path to : localhost:8080/index
@Controller // Class Define as a Controller
@RequestMapping(path = "/")
public class ItemsController 
{
    @Autowired // Repository that will handle the data
    private ItemsRepository ItemsRepository;

    // Get All From Database
    @GetMapping(path = "/index")
    public @ResponseBody Iterable <Items> getAllItems()
    {
        return ItemsRepository.findAll();
    }

    // Get Images from Database
    @GetMapping(path = "/image/{id}")
    public ResponseEntity<byte[]>getImage(@PathVariable("id") Integer id) throws SQLException
    {
        Optional<Items> items = ItemsRepository.findById(id);
        byte[] imagesBytes = null;

        // Optain JPG images
        if(items.isPresent())
        {
            imagesBytes = items.get().getPicture().getBytes(1,(int)items.get().getPicture().length());
        }
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagesBytes);
    }

}