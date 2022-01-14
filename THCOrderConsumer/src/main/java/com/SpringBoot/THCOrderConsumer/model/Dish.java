package com.SpringBoot.THCOrderConsumer.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "dish")
@IdClass(DishId.class)
public class Dish {
    @Id
    private String id;
    private String name;

    @ElementCollection
    private List<String> ingredients;

    @Id
    private String orderId;
}
