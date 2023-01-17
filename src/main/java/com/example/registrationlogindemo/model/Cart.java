package com.example.registrationlogindemo.model;

import com.example.registrationlogindemo.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart",uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "product_id"}))
public class Cart implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;

    @NotNull
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id")
//    private Product products;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id")
//    private User users;

}
