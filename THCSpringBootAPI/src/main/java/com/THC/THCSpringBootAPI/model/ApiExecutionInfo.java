package com.THC.THCSpringBootAPI.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@ApiModel
public class ApiExecutionInfo {
    @Id
    private String id;
    private String name;
    private String date;
    private long executionTime;
    private Timestamp timestamp;

    public ApiExecutionInfo() {
        this.id = UUID.randomUUID().toString();
    }
}
