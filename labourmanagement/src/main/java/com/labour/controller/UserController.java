package com.labour.controller;

import com.labour.config.MyConfig;
import com.labour.dao.UserRepository;
import com.labour.entities.Labour;
import com.labour.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @ModelAttribute
    public void addCommonData(Model model, Principal principal){
        String userName = principal.getName();
        System.out.println("Username = "+ userName);
//        get the user using user name
        User user= userRepository.getUserByUserName(userName);
        System.out.println("USER"+ user);
        model.addAttribute("user", user);
    }
    @RequestMapping("/index")
    public String user_dashboard(Model model, Principal principal) {
        model.addAttribute("title", "User Dashboard");

        return "normal/user_dashboard";
    }
    @GetMapping("/add-labour")
    public String openAddContactForm(Model model){
        model.addAttribute("title", "Add Labour");
        model.addAttribute("labour", new Labour());
        return "normal/add_labour_form";
    }

    @PostMapping("/process-labour")
    public String processLabour(@ModelAttribute Labour labour, Principal principal) {
        String name = principal.getName();
        User user = this.userRepository.getUserByUserName(name);
            labour.setUser(user);
            user.getLabour().add(labour);
        this.userRepository.save(user);
//        System.out.println("DATA" + labour);
        System.out.println("Add to data base");
        return "normal/add_labour_form";
    }
}
