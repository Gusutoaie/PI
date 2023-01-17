package com.example.registrationlogindemo.controller;

import com.example.registrationlogindemo.Nobody.UserDto;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.model.Cart;
import com.example.registrationlogindemo.model.Orders;
import com.example.registrationlogindemo.model.Product;
import com.example.registrationlogindemo.repository.CartRepository;
import com.example.registrationlogindemo.repository.OrdersRepository;
import com.example.registrationlogindemo.repository.ProductRepository;
import com.example.registrationlogindemo.repository.UserRepository;
import com.example.registrationlogindemo.service.impl.EmailSenderServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.DecimalFormat;
import java.util.*;

@Controller
public class CartController {
    private static SessionFactory factory;
    Long saveId;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    private EmailSenderServiceImpl emailSenderService;
    private static final DecimalFormat df = new DecimalFormat("###.##");
    List<Optional<Product>> test = new ArrayList<Optional<Product>>();
    @GetMapping("/shoppingCart")
    public String showCart(Model model, Principal principal){
        User user = userRepository.findByEmail(principal.getName());
        List<Product> products = new ArrayList<>();
        model.addAttribute("count",cartRepository.howManyProducts(user.getId()));
        model.addAttribute("product",productRepository.findProductFromId(user.getId()));
        double totalPrice = Double.parseDouble(df.format(cartRepository.sumTotalPrice(user.getId())));
        model.addAttribute("totalPrice",totalPrice);
        return "shoppingCart";
    }

    @PostMapping("/shoppingCart/{id}")
    public String shoppingCart(@PathVariable Long id,Principal principal){
        Cart cart = new Cart();
        cart.setUser(userRepository.findByEmail(principal.getName()));
        cart.setProduct(productRepository.cautaDupaId(id));
        cart.setQuantity(1);
        try {
            cartRepository.save(cart);
        }catch (DataIntegrityViolationException e){
            return "redirect:/shoppingCart";
        }

        saveId = id;
        return "redirect:/shoppingCart";
    }
    @PostMapping("/shoppingCart/delete")
    public String deleteCart(Principal principal){
        User user = userRepository.findByEmail(principal.getName());
        cartRepository.deleteAfterUserId(user.getId());
        return "redirect:/shoppingCart";
    }
    @GetMapping("/shoppingCart/delete/{id}")
    public String deleteproductid(@PathVariable("id") Long id,Model model,Principal principal) {
        User user=userRepository.findByEmail(principal.getName());
        cartRepository.deleteforid(id);
        model.addAttribute("product",productRepository.findProductFromId(user.getId()));
        return "redirect:/shoppingCart";
    }

    @GetMapping("/sendorder")
    public String sendOrder(Model model, Principal principal){
        Orders order = new Orders();
        User user = userRepository.findByEmail(principal.getName());
        double totalPrice = Double.parseDouble(df.format(cartRepository.sumTotalPrice(user.getId())));
        model.addAttribute("product",productRepository.findProductFromId(user.getId()));
        model.addAttribute("order",order);
        model.addAttribute("count",cartRepository.howManyProducts(user.getId()));
        model.addAttribute("totalPrice", totalPrice);
        return "sendorder";
    }
    @PostMapping("/sendorder/succes")
    public String sendOrdersucces(@Valid @ModelAttribute("order") Orders order, Principal principal){

        String nume = principal.getName();
        order.setUser(userRepository.findByEmail(nume));
        User user1 = userRepository.findByEmail(nume);
        Product product2 = productRepository.cautaDupaId(saveId);
        order.setProducts(productRepository.findProductFromId(user1.getId()));
        emailSenderService.sendEmail(nume,"Comanda ta",buildEmail(product2,user1));
        ordersRepository.save(order);
        return "redirect:/";
    }



    private String buildEmail(Product product, User user){
        return "<div color:red;>Ovidiuuuuuuu </div>" + "<p color:black>Testt</p>";
    }
}