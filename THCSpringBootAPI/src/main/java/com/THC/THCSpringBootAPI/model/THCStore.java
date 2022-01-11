package com.THC.THCSpringBootAPI.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "stores")
@ApiModel
public class THCStore {
    @Id
    private String id;
    private Address address;
    private Hour hour;
    private Menu menu;
    private List<Reservation> reservationList;
    private List<Orders> ordersList;

    public THCStore() {
        this.id = UUID.randomUUID().toString();
        this.ordersList = new ArrayList<>();
        this.reservationList = new ArrayList<>();
    }
}
