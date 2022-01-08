package com.THC.THCSpringBootAPI.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class Reservation {
    @Id
    private String id;
    private String storeId;
    private Timestamp time;

    public Reservation() {
        this.id = UUID.randomUUID().toString();
    }
}
