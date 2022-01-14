package com.SpringBoot.THCOrderConsumer.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
@IdClass(OrderId.class)
public  class Orders {
    @Id
    private String id;
    @Id
    private String storeId;
    private String customerName;
    private String customerContact;
    @OneToMany(cascade = {
            CascadeType.ALL
    })
    private List<Dish> items;
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderedAt;
}
