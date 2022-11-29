package com.demo.server.Controller;

// Import From Java Packages
import com.demo.server.model.Items;
import com.demo.server.Repository.ItemsRepository;
import java.util.List;

// Imports Spring Classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

// Set Path to : localhost:8080/index
@Controller // Class Define as a Controller
@RequestMapping(path = "/")
public class ItemsController 
{
    private final ItemsRepository itemsRepository;
    @Autowired // Repository that will handle the data
    public ItemsController(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = {"application/json"})
    public @ResponseBody List<Items> listItems() {
        return itemsRepository.findAll();
    }


    @RequestMapping(
            method = RequestMethod.POST,
            consumes = {"application/json"})
    public @ResponseBody void addItem(@RequestBody Items item) {
        itemsRepository.save(item);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            consumes = {"application/json"})
    public @ResponseBody void updateItem(@RequestBody Items item) {
        itemsRepository.save(item);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody void deleteItem(@RequestParam("id") int id) {
        itemsRepository.deleteById(id);
    }

    /*
    @GetMapping(path = "/index")
    public @ResponseBody Iterable <Items> getAllItems()
    {
        return ItemsRepository.findAll();
    }
    */
}