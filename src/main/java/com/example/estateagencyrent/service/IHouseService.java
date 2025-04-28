package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.House;

import java.util.List;

public interface IHouseService extends IGeneralService<House> {
    List<House> top3RentHouse();
}
