package com.example.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.home.service.UserService;

import com.example.home.entity.User;
import com.example.home.repository.UserRepository;

import jakarta.validation.Valid;

@Controller
public class StudentController {

     @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

   /*  @GetMapping("/login")
    public String login(){
        return "login";
    } */
    @GetMapping("/blogs")
    public String blogs(){
        return "blogs";
    }
    @GetMapping("/properties")
    public String properties(){
        return "properties";
    }

    @GetMapping("/register")
    public String register(Model theModel){
        theModel.addAttribute("user", new User());
        return "register";
    }

 /*    @PostMapping("/processR")
    public String processRegister(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult) {
        if (theBindingResult.hasErrors()) {
            return "register"; // Ensure this matches the name of your registration form template
        }
        userRepository.save(theUser);
       
        return "register-confirm";  // Corrected template name
    } */

    @PostMapping("/processR")
    public String processRegister(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult, Model model) {
    if (theBindingResult.hasErrors()) {
        return "register"; // Stay on the registration page if there are errors
    }
    userRepository.save(theUser);

    model.addAttribute("user", theUser); // Pass the user object to the view
    model.addAttribute("confirmation", true); // Add a flag to indicate the form was submitted

    return "register"; // Return to the same page
}

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("error", false); // Initialize error message
        return "login"; // This should be the name of your Thymeleaf template
    }
    @Autowired
    private UserService userService;


    @PostMapping("/processL")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        // Authenticate the user and fetch user details
        User user = userService.authenticate(email, password);
        
        if (user != null) {
            model.addAttribute("message", "Login successful!");
            System.out.println("User Role: " + user.getRole()); // Log the role
            
            // Redirect based on role
            if ("admin".equalsIgnoreCase(user.getRole())) {
                return "redirect:/listusers"; // Check if this redirects properly
            } else {
                return "redirect:/properties";
            }
        } else {
            model.addAttribute("error", true);
            return "login"; // Show the login page again if authentication fails
        }
    }
        





















/*     @PostMapping("/processL")
    public ModelAndView handleLogin(@ModelAttribute("user") User user) {
        // Print received values to the console
        System.out.println("Received email: " + user.getEmail());
        System.out.println("Received password: " + user.getPassword());
    
        // Check if the credentials are correct
        // In a real application, replace this with proper authentication logic
        if ("user@example.com".equals(user.getEmail()) && "password".equals(user.getPassword())) {
            return new ModelAndView("redirect:/properties");
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Invalid email or password");
            return modelAndView;
        }
    }
     */

    
    
}
