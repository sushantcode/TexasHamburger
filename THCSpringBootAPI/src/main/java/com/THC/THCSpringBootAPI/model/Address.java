package com.THC.THCSpringBootAPI.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
public class Address {
    @Id
    private String id;
    private String street;
    private String city;
    private String state;
    private String zipcode;

    public Address() {
        this.id = UUID.randomUUID().toString();
    }
}
