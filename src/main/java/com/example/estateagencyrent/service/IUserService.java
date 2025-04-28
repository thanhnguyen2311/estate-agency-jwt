package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.User;

import java.util.Optional;


public interface IUserService extends IGeneralService<User> {
    Optional<User> findUserByUsername(String username);
}
