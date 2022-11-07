package com.demo.server.Controller;

import com.demo.server.model.Items;
import com.demo.server.Repository.ItemsRepository;
// Imports Spring Classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Class Define as a Controller
@RequestMapping(path = "/demo")// Path: localhost:8080/demo
public class ItemsController 
{
    @Autowired // Repository that will handle the data
    private ItemsRepository ItemsRepository;

    @GetMapping(path = "/all")
    public @ResponseBody Iterable <Items> getAllItems()
    {
        return ItemsRepository.findAll();
    }
}