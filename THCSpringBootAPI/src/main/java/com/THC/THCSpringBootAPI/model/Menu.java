package com.THC.THCSpringBootAPI.model;

import lombok.Data;

@Data
public class Menu {
    private String id;
    private String name;
    private String[] ingredients;
}
