package com.example.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.home.entity.Property;
import com.example.home.entity.User;
import com.example.home.service.detailsService;
import com.example.home.service.propertyService;

@Controller
public class propertyController {

    @Autowired
    private detailsService thedetailsService;

    @GetMapping("/addproduct")
    public String addProduct() {
        return "addproduct";
    }

    @GetMapping("/listusers")
    public String listuser(Model theModel) {

        List<User> theUser = thedetailsService.findAll();

        // add to the model
        theModel.addAttribute("users", theUser);
        return "list-users";
    }



    @Autowired
    private final propertyService propertyservice;

    public propertyController(propertyService thePropertyService){
        this.propertyservice=thePropertyService;
    }

    @GetMapping("/showFormAdd")
    public String showForm(Model theModel){
        Property theProperty=new Property();
        theModel.addAttribute("property",theProperty);
        return "property-form";
    }

    @GetMapping("/showFormUpdate")
    public String showUpdate(@RequestParam("propertyId") int theId,Model theModel){
        Property theProperty=propertyservice.findbyId(theId);
        theModel.addAttribute("property",theProperty);
        return "property-form";
    }

    @PostMapping("/save")
    public String saveProperty(@ModelAttribute("property") Property theProperty){
        propertyservice.save(theProperty);
        return "property-list";
    }

    @GetMapping("/delete")
    public String deleteProperty(@RequestParam("propertyId") int theId){
        propertyservice.deletebyId(theId);
        return "property-list";
    }

    @GetMapping("/list")
    public String listProperties(Model theModel){
        List<Property> theList=propertyservice.findAll();
        theModel.addAttribute("property",theList);
        return "property-list";
    }

    @GetMapping("/properties-page")
    public String prop(Model theModel){
        List<Property> theList=propertyservice.findAll();
        theModel.addAttribute("propertys",theList);
        return "properties-page";
    }

}
