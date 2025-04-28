package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.House;
import com.example.estateagencyrent.entity.User;
import com.example.estateagencyrent.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public House save(User user) {
        userRepository.save(user);
        return null;
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }


    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }
}
