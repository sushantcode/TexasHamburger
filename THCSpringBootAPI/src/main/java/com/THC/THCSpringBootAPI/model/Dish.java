package com.THC.THCSpringBootAPI.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@ApiModel
public class Dish {
    @Id
    private String id;
    private String name;
    private String[] ingredients;

    public Dish() {
        this.id = UUID.randomUUID().toString();
    }
}
