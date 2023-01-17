package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.model.Orders;

public interface OrdersService {
    void saveOrder(Orders orders,String email, Long id);
}
