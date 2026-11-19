package com.codedecode.resturantlist.controller;

import java.util.*;
import com.codedecode.resturantlist.dto.ResturantDTO;
import com.codedecode.resturantlist.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resturant")
@CrossOrigin(origins = "http://localhost:4200")
public class ResturantController {

    @Autowired
    ResturantService resturantService;

    @GetMapping("/fetchAllResturant")
    public ResponseEntity<List<ResturantDTO>> fetchAllResturant() {
        List<ResturantDTO> allResturant = resturantService.findAllResturant();
        return new ResponseEntity<>(allResturant, HttpStatus.OK);
    }


    @PostMapping("/addRestaurant")
    public ResponseEntity<ResturantDTO> saveRestaurant(@RequestBody ResturantDTO restaurantDTO) {
        ResturantDTO restaurantAdded = resturantService.addRestaurantInDB(restaurantDTO);
        return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
    }

    @GetMapping("fetchById/{id}")
    public ResponseEntity<ResturantDTO> findRestaurantById(@PathVariable Integer id) {
        return resturantService.fetchRestaurantById(id);
    }

}
