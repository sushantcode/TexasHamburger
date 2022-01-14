package com.SpringBoot.THCOrderConsumer.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderId implements Serializable {

    private String id;
    private String storeId;
}
