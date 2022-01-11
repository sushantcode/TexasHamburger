package com.THC.THCSpringBootAPI.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Data
@ApiModel
public class Menu {
    @Id
    private String id;
    private List<Dish> dishes;

    public Menu() {
        this.id = UUID.randomUUID().toString();
    }
}
