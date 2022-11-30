package com.demo.server.controller;

// Import From Java Packages
import com.demo.server.model.Items;
import com.demo.server.repository.ItemsRepository;

// Imports Spring and Java Classes
import java.sql.SQLException;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
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

    // Return the image from the database using ResponseEntity
	@GetMapping("image/{id}")
	public ResponseEntity<byte[]> fromDatabaseAsResEntity(@PathVariable("id") Integer id) throws SQLException {

		Optional<Items> items = ItemsRepository.findById(id);
		byte[] imageBytes = null;
		if (items.isPresent()) {

			imageBytes = items.get().getPhoto().getBytes(1,
					(int) items.get().getPhoto().length());
		}

		return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	}
}