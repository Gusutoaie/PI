package com.example.registrationlogindemo.repository;

import com.example.registrationlogindemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//JpaRepository<Product, Long>
public interface ProductRepository extends CrudRepository<Product,Long> {

    Optional<Product> findById(Long aLong);

    @Query(value = "SELECT * FROM products WHERE id = ?1 ",nativeQuery = true)
    Product cautaDupaId(Long id);

    @Query(value = "SELECT * FROM products WHERE category = ?1 ",nativeQuery = true)
    Product cautaDupaCategorie(String nume);

    @Query(value = "SELECT p.* FROM products p INNER JOIN cart c ON c.product_id = p.id WHERE c.user_id = :userId",nativeQuery = true)
    List<Product> findProductFromId(@Param("userId") Long userId);


//    @Query(value = "",nativeQuery = true)
//    List<Product> findProductFromId(@Param("userId") Long userId);
}
