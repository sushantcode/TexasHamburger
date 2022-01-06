package com.THC.THCSpringBootAPI.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Reservation {
    private String id;
    private Timestamp time;
}
