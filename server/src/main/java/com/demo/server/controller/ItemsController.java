package com.demo.server.controller;

// Import From Java Packages
import com.demo.server.model.Items;
import com.demo.server.repository.ItemsRepository;

// Imports Spring and Java Classes
import java.util.Optional;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

// Set Path to : localhost:8080/items
@Controller // Class Define as a Controller
public class ItemsController 
{
    private final ItemsRepository itemsRepository;

    @Autowired // Repository that will handle the data
    public ItemsController(ItemsRepository itemsRepository) 
    {
        this.itemsRepository = itemsRepository;
    }

    @GetMapping("/")
    public String listItems(Model model)
    {
        model.addAttribute("allItems", itemsRepository.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String addItem(Model model)
    {
        Items item = new Items();
        model.addAttribute("item", item);
        return "newItem";
    }

    @PostMapping("/save")
    public String saveItem(@ModelAttribute("item") Items item)
    {
        itemsRepository.save(item);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable(value = "id") Integer id)
    {
        itemsRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
	public void showItemsImage(@PathVariable("id") Integer Id, HttpServletResponse response,Optional<Items> item) 
    throws ServletException, IOException
    {
        item = itemsRepository.findById(Id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.get().getPicture());
        response.getOutputStream().close();
    }

    /* */
    @GetMapping("/name_asc")
    public String listItemsByNameAsc(Model model)
    {
        // Choose Sort Location
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("allItems", itemsRepository.findAll(sort));
        return "redirect:/";
    }

    @GetMapping("/price_asc")
    public String listItemsByPriceAsc(Model model)
    {
        // Choose Sort Location
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("allItems", itemsRepository.findAll(sort));
        return "redirect:/";
    }

    @GetMapping("/price_desc")
    public String listItemsByPriceDesc(Model model)
    {
        // Choose Sort Location
        Sort sort = Sort.by("name").descending();
        model.addAttribute("allItems", itemsRepository.findAll(sort));
        return "redirect:/";
    }

    /*   
    @GetMapping("items/image/{id}")
	public void showItemsImage(@PathVariable("id") Integer Id, HttpServletResponse response,Optional<Items> item) 
    throws ServletException, IOException
    {
        item = itemsRepository.findById(Id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
        response.getOutputStream().write(item.get().getPicture());
        response.getOutputStream().close();
    }

    @GetMapping("items/details")
	public String showItemsDetails(@RequestParam("id") Integer Id, Optional<Items> item,Model model) 
    {
        item = itemsRepository.findById(Id);
        
        if(item.isPresent())
        {
            model.addAttribute("id", item.get().getId());
            model.addAttribute("name", item.get().getName());
            model.addAttribute("description", item.get().getDescription());
            model.addAttribute("price", item.get().getPrice());
            model.addAttribute("quantity_on_stock", item.get().getQuantity_on_stock());
            return "details/{id}";
        }
        return "redirect:/items";
    }

    // Display Sorted Price
    @GetMapping("/items/asc")
    public @ResponseBody List<Items> listItemsAsc()
    {
        // Choose Sort Location
        Sort sort = Sort.by("price").ascending();
        return itemsRepository.findAll(sort);
    }

    @GetMapping("/items/desc")
    public @ResponseBody List<Items> listItemsDesc()
    {
        // Choose Sort Location
        Sort sort = Sort.by("price").descending();
        return itemsRepository.findAll(sort);
    }
    */
    
}