package com.THC.THCSpringBootAPI.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "stores")
public class THCStore {
    @Id
    private String id;
    private Address address;
    private Hour hour;
    private Menu menu;

    public THCStore() {
        this.id = UUID.randomUUID().toString();
    }
}
