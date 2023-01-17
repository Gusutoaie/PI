package com.example.registrationlogindemo.model;

import com.example.registrationlogindemo.Nobody.UserDto;
import com.example.registrationlogindemo.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String fullName;
    @Email
    @NotNull
    private String email;
    @NotNull
    private String phoneNumber;
    @NotNull
    private String address;
    @NotNull
    private String county;
    @NotNull
    private String city;
    @NotNull
    private String zip;
    private String otherinfo;
    @CreationTimestamp
    private Date createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="orders_products",
            joinColumns={@JoinColumn(name="ORDER_ID", referencedColumnName="ID")},
            inverseJoinColumns={@JoinColumn(name="PRODUCT_ID", referencedColumnName="ID")})
    private List<Product> products = new ArrayList<>();

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_user")
//    private User user;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_product")
//    private Product product;

}
