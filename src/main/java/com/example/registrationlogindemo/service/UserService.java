package com.example.registrationlogindemo.service;

import com.example.registrationlogindemo.Nobody.UserDto;
import com.example.registrationlogindemo.entity.User;
import com.example.registrationlogindemo.model.Product;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();

}
