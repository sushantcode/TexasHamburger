package com.THC.THCSpringBootAPI.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {
    private static final Logger logger = LogManager.getLogger(LocationController.class);

    @GetMapping
    public String getLocations() {
        logger.info("API Request made to get location list");
        return "This is sample location get method.";
    }

    @PostMapping("/addNewLocation")
    public boolean addNewLocation(@RequestBody String data) {
        logger.info("API Request made to add location");
        return true;
    }

    @GetMapping("/findLocation")
    public String findLocation(@RequestParam String id) {
        logger.info("API Request made to find location by id");
        return "Location with id " + id;
    }

    @PutMapping("/updateLocation")
    public boolean updateLocation(@RequestParam String id) {
        logger.info("API Request made to update a location");
        return true;
    }

    @DeleteMapping("/removeLocation")
    public boolean removeLocation(@RequestParam String id) {
        logger.info("API Request made to delete a location");
        return true;
    }
}
