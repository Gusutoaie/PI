package com.example.registrationlogindemo.service.impl;

import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.model.Orders;
import com.example.registrationlogindemo.model.Product;
import com.example.registrationlogindemo.repository.OrdersRepository;
import com.example.registrationlogindemo.repository.ProductRepository;
import com.example.registrationlogindemo.repository.UserRepository;
import com.example.registrationlogindemo.service.OrdersService;

import java.util.Optional;


public class OrdersServiceImpl implements OrdersService {
    OrdersRepository ordersRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    public OrdersServiceImpl(OrdersRepository ordersRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.ordersRepository = ordersRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void saveOrder(Orders orders, String email, Long id) {
        Orders orders1 = new Orders();
        User user = userRepository.findByEmail(email);
        user.getId();
     
        ordersRepository.save(orders);
    }

}
