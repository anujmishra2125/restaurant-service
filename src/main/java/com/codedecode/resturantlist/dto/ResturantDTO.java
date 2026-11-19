package com.codedecode.resturantlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResturantDTO {
    private int id;
    private String name;
    private String addr;
    private String city;
    private String desc;
}
