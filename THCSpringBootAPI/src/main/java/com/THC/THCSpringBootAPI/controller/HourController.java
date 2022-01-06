package com.THC.THCSpringBootAPI.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hour")
public class HourController {
    private static final Logger logger = LogManager.getLogger(LocationController.class);

    @GetMapping
    public String getHours() {
        logger.info("list of hours is requested");
        return "This is sample location get method.";
    }
}
