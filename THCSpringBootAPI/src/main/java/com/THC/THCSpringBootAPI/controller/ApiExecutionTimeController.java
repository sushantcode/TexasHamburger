package com.THC.THCSpringBootAPI.controller;

import com.THC.THCSpringBootAPI.model.ApiExecutionInfo;
import com.THC.THCSpringBootAPI.service.ThcApiService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/execution")
public class ApiExecutionTimeController {
    private static final Logger logger = LogManager.getLogger(OrdersController.class);

    private final ThcApiService thcApiService;

    @Autowired
    public ApiExecutionTimeController(ThcApiService thcApiService) {
        this.thcApiService = thcApiService;
    }

    @GetMapping("/name")
    @ApiOperation(value = "get API Execution Time records by name",
            notes = "filter the API Execution Time records from MySql-DBMS by the name of path.")
    public ResponseEntity<?> getExecutionTimeByName(@RequestParam String name) {
        logger.info("API Request made to push api execution time object");
        List<ApiExecutionInfo> apiExecutionInfos = thcApiService.apiExecutionInfoByName(name);
        if (apiExecutionInfos == null) {
            return new ResponseEntity<>(
                    "Something went wrong",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(apiExecutionInfos, HttpStatus.OK);
    }

    @GetMapping("/date")
    @ApiOperation(value = "get API Execution Time records by date",
            notes = "filter the API Execution Time records from MySql-DBMS by the date.")
    public ResponseEntity<?> getExecutionTimeByDate(@RequestParam String date) {
        logger.info("API Request made to push api execution time object");
        List<ApiExecutionInfo> apiExecutionInfos = thcApiService.apiExecutionInfoByDate(date);
        if (apiExecutionInfos == null) {
            return new ResponseEntity<>(
                    "Something went wrong",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(apiExecutionInfos, HttpStatus.OK);
    }
}
