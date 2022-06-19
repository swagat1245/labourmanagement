package com.labour.controller;

import com.labour.dao.UserRepository;
import com.labour.entities.User;
import com.labour.helper.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("title","Home - Labour Manager");
        return "home";
    }
    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("title","About - Labour Manager");
        return "about";
    }
    @RequestMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("title","Signup - Labour Manager");
        model.addAttribute("user",new User());
        return "signup";
    }

    @RequestMapping(value = "do_register", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user,BindingResult result1, @RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model, HttpSession session) {
        try{
        if(!agreement){
            System.out.println("you have not agreed terms and conditions");
            throw new Exception("you have not agreed terms and conditions");
        }
        if (result1.hasErrors()){
            System.out.println("Error"+result1.toString());
            model.addAttribute("user",user);
            return "signup";
        }

        user.setEnabled(true);
        user.setRole("Role_USER");
        System.out.println("agreement" + agreement);
        System.out.println("user" + user);


        User result = this.userRepository.save(user);
        model.addAttribute("user",new User());
            session.setAttribute("message",new Message("Successfully Registered !!","alert-success"));
            return "signup";

        }
        catch (Exception e){
            model.addAttribute("user",user);
            session.setAttribute("message",new Message("Something went wrong !!"+e.getMessage(),"alert-danger"));
            return "signup";
        }
    }

}
