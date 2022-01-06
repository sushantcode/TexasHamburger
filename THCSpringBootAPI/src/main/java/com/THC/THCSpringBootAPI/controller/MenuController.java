package com.THC.THCSpringBootAPI.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LogManager.getLogger(LocationController.class);

    @GetMapping
    public String getMenus() {
        logger.info("API Request made to get menu list");
        return "This is sample menu get method.";
    }

    @PostMapping("/addNewMenu")
    public boolean addNewMenu() {
        logger.info("API Request made to add new menu");
        return true;
    }

    @GetMapping("/findMenu")
    public String findMenu(@RequestParam String id) {
        logger.info("API Request made to find location");
        return "Menu with id " + id;
    }

    @PutMapping("/updateMenu")
    public boolean updateMenu(@RequestParam String id) {
        logger.info("API Request made to update a menu");
        return true;
    }

    @DeleteMapping("/removeMenu")
    public boolean removeMenu(@RequestParam String id) {
        logger.info("API Request made to delete a menu");
        return true;
    }
}
