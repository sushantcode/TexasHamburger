package com.THC.THCSpringBootAPI.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@ApiModel
public  class Orders {
    @Id
    private String id;
    private String storeId;
    private String customerName;
    private String customerContact;
    private List<Dish> items;
    private Date orderedAt;

    public Orders() {
        this.id = UUID.randomUUID().toString();
        this.orderedAt = new Date();
    }
}
