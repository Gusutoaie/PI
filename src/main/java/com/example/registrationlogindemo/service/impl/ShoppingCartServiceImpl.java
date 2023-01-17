package com.example.registrationlogindemo.service.impl;

import com.example.registrationlogindemo.model.Product;
import com.example.registrationlogindemo.repository.ProductRepository;
import com.example.registrationlogindemo.service.ShoppingCartService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ProductRepository productRepository;

    public ShoppingCartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    private Map<Product, Integer> products = new HashMap<>();
    @Override
    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            products.replace(product, products.get(product) + 1);
        } else {
            products.put(product, 1);
        }
    }
    @Override
    public void removeProduct(Product product) {
        if (products.containsKey(product)) {
            if (products.get(product) > 1)
                products.replace(product, products.get(product) - 1);
            else if (products.get(product) == 1) {
                products.remove(product);
            }
        }
    }
    @Override
    public Map<Product, Integer> getProductsInCart() {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public BigDecimal getTotal() {
        return null;
    }

    @Override
    public void checkout() {

    }


}
