package com.THC.THCSpringBootAPI.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Data
public class Menu {
    @Id
    private String id;
    private List<Dish> dishes;

    public Menu() {
        this.id = UUID.randomUUID().toString();
    }
}
