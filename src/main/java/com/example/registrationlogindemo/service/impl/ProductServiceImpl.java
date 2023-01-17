package com.example.registrationlogindemo.service.impl;

import com.example.registrationlogindemo.model.Product;
import com.example.registrationlogindemo.repository.ProductRepository;
import com.example.registrationlogindemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    public ProductServiceImpl( ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProduct(){
        return (List<Product>) productRepository.findAll();
    }
    @Override
    public Optional<Product> cautDupaId(Long id){
        return productRepository.findById(id) ;
    }


}
