package com.THC.THCSpringBootAPI.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Data
@ApiModel
public class Reservation {
    @Id
    private String id;
    private String storeId;
    private String customerName;
    private String customerContact;
    private String tableNumber;
    private Date reservationTime;
    private Date reservedAt;

    public Reservation() {
        this.id = UUID.randomUUID().toString();
        this.reservedAt = new Date();
    }
}
