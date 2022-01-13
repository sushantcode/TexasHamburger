package com.SpringBoot.THCOrderConsumer.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class DishId implements Serializable {

    private String id;
    private String orderId;
}
