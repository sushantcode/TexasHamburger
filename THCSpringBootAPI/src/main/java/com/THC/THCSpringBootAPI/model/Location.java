package com.THC.THCSpringBootAPI.model;

import lombok.Data;

@Data
public class Location {
    private String id;
    private String address;
    private String city;
    private String state;
    private int zipcode;
}
