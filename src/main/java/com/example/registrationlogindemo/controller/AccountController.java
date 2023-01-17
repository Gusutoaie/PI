package com.example.registrationlogindemo.controller;

import ch.qos.logback.core.joran.action.ImplicitModelData;
import com.example.registrationlogindemo.Nobody.UserDto;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.model.Product;
import com.example.registrationlogindemo.repository.OrdersRepository;
import com.example.registrationlogindemo.repository.ProductRepository;
import com.example.registrationlogindemo.repository.UserRepository;
import com.example.registrationlogindemo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;


@Controller
public class AccountController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductRepository productRepository;

    private UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/account")
    public String account(Model model, Principal principal) {
        User user  =  userRepository.findByEmail(principal.getName());
        model.addAttribute("user",user);
        boolean hasAdminRole = user.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"));
        model.addAttribute("hasAdminRole", hasAdminRole);
        return "account";
    }
    @GetMapping("/account/{name}")
    public String accountName(@PathVariable String name, Model model, Principal principal) {
        User user  =  userRepository.findByEmail(principal.getName());
        boolean hasAdminRole = user.getRoles().stream().anyMatch(role -> role.getName().equals("ROLE_ADMIN"));
        model.addAttribute("hasAdminRole", hasAdminRole);
        System.out.println(name);
        if(name.equals("myorders")){
            model.addAttribute("orders",ordersRepository.returnAllordersWithUserId(user.getId()));
            System.out.println(ordersRepository.returnAllordersWithUserId(user.getId()));
        }
        return "account";
    }
    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/admin/{name}")
    public String adminUrl(@PathVariable String name, Model model, RedirectAttributes redirectAttributes){
        if(name.equals("users")){
            List<UserDto> users = userService.findAllUsers();
            model.addAttribute("users", users);
        }
        if(name.equals("tickets")){

        }
        if(name.equals("orders")){
            model.addAttribute("orders", ordersRepository.findAll());
        }
       if(name.equals("addproduct")){
            Product product = new Product();
            redirectAttributes.addFlashAttribute("product",product);
            return "redirect:/admin";
       }
        return "admin";
    }
    @PostMapping("/admin/add")
    public String addProduct(@ModelAttribute("product") Product product, BindingResult result){
        productRepository.save(product);
        return "redirect:/admin";
    }
}
