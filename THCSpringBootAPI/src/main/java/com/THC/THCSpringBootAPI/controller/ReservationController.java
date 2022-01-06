package com.THC.THCSpringBootAPI.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private static final Logger logger = LogManager.getLogger(LocationController.class);

    @GetMapping
    public String getReservation() {
        logger.info("API Request made to get reservation list");
        return "This is sample location get method.";
    }

    @PostMapping("/addNewReservation")
    public boolean addNewReservation() {
        logger.info("API Request made to add new reservation");
        return true;
    }

    @GetMapping("/findReservation")
    public String findReservation(@RequestParam String id) {
        logger.info("API Request made to find reservation");
        return "Reservation with id " + id;
    }

    @PutMapping("/updateResrvation")
    public boolean updateResrvation(@RequestParam String id) {
        logger.info("API Request made to update a reservation");
        return true;
    }

    @DeleteMapping("/removeReservation")
    public boolean removeReservation(@RequestParam String id) {
        logger.info("API Request made to delete a reservation");
        return true;
    }
}
