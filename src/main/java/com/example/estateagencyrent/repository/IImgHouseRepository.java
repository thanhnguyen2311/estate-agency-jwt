package com.example.estateagencyrent.repository;

import com.example.estateagencyrent.entity.House;
import com.example.estateagencyrent.entity.ImgHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImgHouseRepository extends JpaRepository<ImgHouse, Long> {
    List<ImgHouse> findAllByHouse(House house);
    void deleteAllByHouse(House house);
}
