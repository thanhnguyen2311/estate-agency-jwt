package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.House;

import java.util.Optional;

public interface IGeneralService<T>{
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    House save(T t);

    void remove(Long id);
}
