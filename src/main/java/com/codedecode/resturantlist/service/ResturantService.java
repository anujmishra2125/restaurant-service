package com.codedecode.resturantlist.service;

import com.codedecode.resturantlist.dto.ResturantDTO;
import com.codedecode.resturantlist.entity.Resturant;
import com.codedecode.resturantlist.mapper.ResturantMapper;
import com.codedecode.resturantlist.repo.ResturantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ResturantService {

    @Autowired
    ResturantRepo resturantRepo;

    public List<ResturantDTO> findAllResturant() {
        List<Resturant> resturants = resturantRepo.findAll();
        List<ResturantDTO> resturantDTOList = resturants.stream()
                .map(resturant -> ResturantMapper.INSTANCE.mapResturantToMapRestrurantDTO(resturant))
                .collect(Collectors.toList());

        return  resturantDTOList;
    }

    public ResturantDTO addRestaurantInDB(ResturantDTO restaurantDTO) {
        Resturant savedRestaurant =  resturantRepo.save(ResturantMapper.INSTANCE.mapRestrurantDTOToResturant(restaurantDTO));
        return ResturantMapper.INSTANCE.mapResturantToMapRestrurantDTO(savedRestaurant);
    }

    public ResponseEntity<ResturantDTO> fetchRestaurantById(Integer id) {
        Optional<Resturant> restaurant =  resturantRepo.findById(id);
        if(restaurant.isPresent()){
            return new ResponseEntity<>(ResturantMapper.INSTANCE.mapResturantToMapRestrurantDTO(restaurant.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>((HttpHeaders) null, HttpStatus.NOT_FOUND);
    }
}
