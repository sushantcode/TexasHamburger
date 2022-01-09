package com.THC.THCSpringBootAPI.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
public  class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String storeId;
    private String customerName;
    private String customerContact;

    @ElementCollection
    private List<String> items;
    private Timestamp time;
}
