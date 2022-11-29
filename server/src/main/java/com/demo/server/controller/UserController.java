package com.demo.server.controller;

// Import Classes
import com.demo.server.model.User;
import com.demo.server.service.UserService;

// Import Java & Spring Packages
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
 
                                  
    @GetMapping("/login")
          
    public ModelAndView login() {
     ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }
 
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user ) {
    
     User oauthUser = userService.login(user.getEmail(), user.getPassword());
    
 
     System.out.print(oauthUser);
     if(Objects.nonNull(oauthUser))
     {
  
     return "redirect:/";
    
    
     } else {
     return "redirect:/login";
    
    
     }
 
}
    
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
    
  
        return "redirect:/login";
    } 
}
