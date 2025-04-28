package com.example.estateagencyrent.controller;

import com.example.estateagencyrent.entity.ObjectSearchRangeTime;
import com.example.estateagencyrent.service.IUserService;
import com.example.estateagencyrent.entity.House;
import com.example.estateagencyrent.entity.RentHouse;
import com.example.estateagencyrent.service.IHouseService;
import com.example.estateagencyrent.service.IRentHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/estate/rent")
public class RentHouseController {
    @Autowired
    private IRentHouseService rentHouseService;
    @Autowired
    private IHouseService houseService;
    @Autowired
    private IUserService userService;

    @GetMapping("{id}")
    public ResponseEntity<List<RentHouse>> findRentHousesByHouse(@PathVariable Long id){
        List<RentHouse> rentHouses = rentHouseService.findAllByHouse(houseService.findById(id).get());
        if (rentHouses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rentHouses, HttpStatus.OK);
    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<List<RentHouse>> findRentHousesByGuest(@PathVariable Long id){
        List<RentHouse> rentHouses = rentHouseService.findAllByGuest(userService.findById(id).get());
        if (rentHouses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(rentHouses, HttpStatus.OK);
    }

    @GetMapping("/top3")
    public ResponseEntity<List<House>> top3RentHouse(){
        List<House> houses = houseService.top3RentHouse();
        if (houses.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(houses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody RentHouse rentHouse){
        boolean flag = rentHouseService.checkRentHouse(rentHouse);
        if (flag){
            rentHouseService.save(rentHouse);
            return new ResponseEntity<>("successful rental!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/checkin/{id}")
    public ResponseEntity<String> checkin(@PathVariable Long id){
        RentHouse rentHouses = rentHouseService.findById(id).get();
        rentHouses.setCheckIn(true);
        rentHouseService.save(rentHouses);
        return new ResponseEntity<>("Checked", HttpStatus.CREATED);
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<RentHouse> cancel(@PathVariable Long id){
        RentHouse rentHouses = rentHouseService.findById(id).get();
        if (rentHouseService.checkCancel(rentHouses)){
        rentHouses.setStatus(false);
        rentHouseService.save(rentHouses);
        return new ResponseEntity<>(rentHouses, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/income/{id}")
    public ResponseEntity<List<Double>> incomeMonthly(@PathVariable Long id){
        return new ResponseEntity<>(rentHouseService.inComeMonthly(id), HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public ResponseEntity<List<House>> search(@RequestBody ObjectSearchRangeTime rangeTime){
        if (rangeTime.getStartDay().isAfter(rangeTime.getEndDay())){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<House> houses = rentHouseService.checkOverLappingIntervals(rangeTime);
        if (!houses.isEmpty()){
            return new ResponseEntity<>(houses, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
