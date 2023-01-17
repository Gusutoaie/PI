package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.model.Cart;

import com.example.registrationlogindemo.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;


import java.util.List;

@Transactional
public interface CartRepository extends JpaRepository<Cart,Long> {
//    @Query(value = "SELECT p.* FROM products p INNER JOIN cart c ON c.product_id = p.id WHERE c.user_id = :userId",nativeQuery = true)
    @Modifying
    @Query(value = "DELETE FROM Cart WHERE product_id = :id",nativeQuery = true)
    void deleteforid(@Param("id") Long id);

    @Modifying
    @Query(value = "DELETE FROM Cart WHERE user_id = :user_id",nativeQuery = true)
    void deleteAfterUserId(@Param("user_id")Long id);

    @Query(value = "SELECT COUNT(*) FROM cart WHERE user_id = :user_id",nativeQuery = true)
    Integer howManyProducts(@Param("user_id")Long id);

    @Query(value = "SELECT COALESCE(SUM(price),0) FROM products p INNER JOIN cart c ON p.id = c.product_id WHERE c.user_id = :user_id", nativeQuery = true)
    double sumTotalPrice(Long user_id);

}
