package com.THC.THCSpringBootAPI.controller;

import com.THC.THCSpringBootAPI.model.Reservation;
import com.THC.THCSpringBootAPI.service.StoreService;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    private static final Logger logger = LogManager.getLogger(ReservationController.class);

    private final StoreService storeService;

    @Autowired
    public ReservationController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "get all reservations",
            notes = "provide store id to get the list of all reservation at that store.")
    public ResponseEntity<?> getAllReservations(@RequestParam String id) {
        logger.info("API Request made to get all reservation for a store");
        List<Reservation> reservationList = storeService.getAllReservations(id);
        if (reservationList == null) {
            return new ResponseEntity<>(
                    "Store with id: " + id + " does not exist.",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(reservationList, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation(value = "create a new reservation",
            notes = "provide store id and reservation object to add reservation to database to " +
                    "that store")
    public ResponseEntity<String> createNewReservation(@RequestParam String id, @RequestBody Reservation reservation) {
        logger.info("API Request made to add new reservation");
        boolean isSuccess = storeService.createNewReservation(id, reservation);
        if (!isSuccess) {
            return new ResponseEntity<>(
                    "Store with id: " + id + " does not exist.",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>("Reservation with id: " + reservation.getId() + " is added", HttpStatus.CREATED);
    }

    @GetMapping("/single")
    @ApiOperation(value = "get a reservation by id",
            notes = "provide store id and the reservation id to retrieve the detail of " +
                    "the particular reservation")
    public ResponseEntity<?> getReservationById(@RequestParam String id, @RequestParam String reservationId) {
        logger.info("API Request made to get reservation for a reservation by id");
        Reservation reservation = storeService.getReservationById(id, reservationId);
        if (reservation == null) {
            return new ResponseEntity<>(
                    "Store with id: " + id + " or reservation with id: " + reservationId + "does not exist.",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    @DeleteMapping("/remove")
    @ApiOperation(value = "remove reservation from a store",
            notes = "provide store id and the reservation id to erase the reservation " +
                    "from the location.")
    public ResponseEntity<String> deleteReservation(@RequestParam  String id, @RequestParam String reservationId) {
        logger.info("API Request made to remove reservation using id");
        boolean isSuccess = storeService.removeReservation(id, reservationId);
        if (!isSuccess) {
            return new ResponseEntity<>(
                    "Store with id: " + id + " or reservation with id: " + reservationId + "does not exist.",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>("Reservation with id: " + reservationId + " is removed", HttpStatus.OK);
    }

    @PutMapping("/modify")
    @ApiOperation(value = "modify a reservation at the store",
            notes = "provide store id and the reservation id along with the new Reservation object" +
                    " to update it's detail.")
    public ResponseEntity<?> modifyResrvation(@RequestParam String id, @RequestParam String reservationId, @RequestBody Reservation reservation) {
        logger.info("API Request made to modify a reservation detail");
        boolean isSuccess = storeService.modifyReservation(id, reservationId, reservation);
        if (!isSuccess) {
            return new ResponseEntity<>(
                    "Store with id: " + id + " or reservation with id: " + reservationId + "does not exist.",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                "Reservation with id:" + reservationId + " has been modified now",
                HttpStatus.OK
        );
    }
}
