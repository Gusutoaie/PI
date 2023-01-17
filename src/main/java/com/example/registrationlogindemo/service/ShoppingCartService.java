package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

public interface ShoppingCartService {
    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    BigDecimal getTotal();

    void checkout();
}
