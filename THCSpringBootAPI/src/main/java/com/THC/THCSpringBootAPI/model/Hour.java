package com.THC.THCSpringBootAPI.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@Data
@ApiModel
public class Hour {
    @Id
    private String id;
    private String mon;
    private String tue;
    private String wed;
    private String thu;
    private String fri;
    private String sat;
    private String sun;

    public Hour() {
        this.id = UUID.randomUUID().toString();
    }
}
