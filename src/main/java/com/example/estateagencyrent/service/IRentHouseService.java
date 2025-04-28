package com.example.estateagencyrent.service;

import com.example.estateagencyrent.entity.House;
import com.example.estateagencyrent.entity.ObjectSearchRangeTime;
import com.example.estateagencyrent.entity.RentHouse;
import com.example.estateagencyrent.entity.User;

import java.util.List;

public interface IRentHouseService extends IGeneralService<RentHouse> {
    List<RentHouse> findAllByHouse(House house);

    boolean checkRentHouse(RentHouse rentHouse);

    List<RentHouse> findAllByGuest(User guest);
    boolean checkCancel(RentHouse rentHouse);
    List<Double> inComeMonthly(Long id);
    List<House> checkOverLappingIntervals(ObjectSearchRangeTime search);
}
