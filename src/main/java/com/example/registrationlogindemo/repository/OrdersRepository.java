package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT * FROM orders WHERE fk_user = :userId",nativeQuery = true)
    List<Orders> returnAllordersWithUserId(Long userId);

}
