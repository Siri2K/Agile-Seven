package com.demo.server.controller;

// Import Classes
import com.demo.server.model.User;
import com.demo.server.service.UserService;

// Import Java & Spring Dependencies
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController 
{
    @Autowired
    private UserService userService;

    // Login Setup
    @GetMapping("/login")
    public ModelAndView login()
    {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user)
    {
        User oAuthUser = userService.login(user.getEmail(), user.getPassword());

        System.out.print(oAuthUser);
        if(Objects.nonNull(oAuthUser))
        {
            return "redirect:/";
        }
        else
        {
            return "redirect:/login"; 
        }
    }

    // Logout Setup
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logout(HttpServletRequest request, HttpServletResponse response)
    {
        return "redirect:/login";  
    }
}