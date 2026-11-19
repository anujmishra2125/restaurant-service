package com.codedecode.resturantlist.mapper;

import com.codedecode.resturantlist.dto.ResturantDTO;
import com.codedecode.resturantlist.entity.Resturant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ResturantMapper {

    ResturantMapper INSTANCE = Mappers.getMapper(ResturantMapper.class);

    Resturant mapRestrurantDTOToResturant(ResturantDTO resturantDTO);
    ResturantDTO mapResturantToMapRestrurantDTO(Resturant resturant);
}
