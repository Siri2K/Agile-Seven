package com.demo.server.controller;

// Import Classes
import com.demo.server.model.Users;
import com.demo.server.service.UsersService;

import java.util.Map;
// Import Java & Spring Packages
import java.util.Objects;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController 
{
    @Autowired
    private UsersService userService;
 
    @PostMapping("/login")
    public void login(@RequestBody Map<String, String> requestBody) {
      String email = requestBody.get("email");
      String password = requestBody.get("password");
  
      // do something with the email and password
    }
                                
    @GetMapping("/login_page")
    public ModelAndView login() 
    {
     ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Users());
        return mav;
    }
 
    @PostMapping("/login_page")
    public String login(@ModelAttribute("user") Users user ) 
    {
    
     Users oauthUser = userService.login(user.getEmail(), user.getPassword());
    
 
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
        System.out.println("Success");
         return "redirect:/";
     } 
     else 
     {
        System.out.println("Failed");
        return "redirect:/login_page";
     }
 
}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/login_page";
    } 
}
