package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.House;
import com.example.estateagencyrent.entity.ImgHouse;

import java.util.List;


public interface IImgHouseService extends IGeneralService<ImgHouse> {
    List<ImgHouse> findImgHousesByHouse(House house);
}
