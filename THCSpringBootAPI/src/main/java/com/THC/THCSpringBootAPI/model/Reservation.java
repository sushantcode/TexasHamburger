package com.THC.THCSpringBootAPI.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String storeId;
    private String customerName;
    private String customerContact;
    private String tableNumber;
    private Date reservationTime;
    private Timestamp time;
}
