package com.THC.THCSpringBootAPI.controller;

import com.THC.THCSpringBootAPI.model.*;
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
@RequestMapping("/api/store")
public class THCStoreController {

    private static final Logger logger = LogManager.getLogger(THCStoreController.class);

    private final StoreService storeService;

    @Autowired
    public THCStoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/all")
    @ApiOperation(value = "get all stores details from database.",
                notes = "returns the list of all stores and their properties " +
                        "including any reservation and orders.")
    public ResponseEntity<?> getAllStores() {
        logger.info("API Request made to get store list");
        List<THCStore> storesList = storeService.retrieveStoreList();
        return new ResponseEntity<>(storesList, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation(value = "add new location/store.",
            notes = "provide new store object to be added to the database " +
                    "and get unique id of the newly created store/location")
    public ResponseEntity<String> addNewStore(@RequestBody THCStore thcStore) {
        logger.info("API Request made to add new store");
        THCStore newStore = storeService.addNewStore(thcStore);
        return new ResponseEntity<>("Store with id: " + newStore.getId() + " is created", HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    @ApiOperation(value = "delete a store by id",
            notes = "removes store/location form the database")
    public ResponseEntity<String> removeStore(@RequestParam String id) {
        logger.info("API Request made to remove store");
        boolean isSuccess = storeService.removeStore(id);
        if (!isSuccess) {
            return new ResponseEntity<>("Store with id: " + id + " does not exist.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Store with id: " + id + " is removed", HttpStatus.OK);
    }

    @GetMapping("/single")
    @ApiOperation(value = "get a location detail by id",
            notes = "returns detail of a single store when provided an id")
    public ResponseEntity<?> getStoreById(@RequestParam String id) {
        logger.info("API Request made to get store by id");
        THCStore store = storeService.getStoreById(id);
        if (store == null) {
            return new ResponseEntity<>("Store with id: " + id + " does not exist.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @PutMapping("/address")
    @ApiOperation(value = "updates address of a store",
            notes = "provide store id and updated Address object to update the " +
                    "address of that location.")
    public ResponseEntity<String> updateAddress(@RequestParam String id, @RequestBody Address address) {
        logger.info("API Request made to update store's address");
        boolean isSuccess = storeService.updateStoreAddress(id, address);
        if (!isSuccess) {
            return new ResponseEntity<>("Store with id: " + id + " does not exist.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Store with id: " + id + " has new address now", HttpStatus.OK);
    }

    @PutMapping("/hour")
    @ApiOperation(value = "updates hours of a store",
            notes = "provide store id and updated hour object to update the " +
                    "hours of that location.")
    public ResponseEntity<String> updateHour(@RequestParam String id, @RequestBody Hour hour) {
        logger.info("API Request made to update store's address");
        boolean isSuccess = storeService.updateStoreHours(id, hour);
        if (!isSuccess) {
            return new ResponseEntity<>("Store with id: " + id + " does not exist.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Store with id: " + id + " has new hours now", HttpStatus.OK);
    }

    @PutMapping("/addDish")
    @ApiOperation(value = "add new dish to the menu of a store",
            notes = "provide store id and new dish object to be added to the menu of that store")
    public ResponseEntity<String> addNewDish(@RequestParam String id, @RequestBody Dish dish) {
        logger.info("API Request made to add new dish to a menu");
        boolean isSuccess = storeService.addDishToStoreMenu(id, dish);
        if (!isSuccess) {
            return new ResponseEntity<>(
                    "Store with id: " + id + " does not exist.",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                "Store with id: " + id + " has new dish with id: " + dish.getId() + " in its menu now",
                HttpStatus.OK
        );
    }

    @DeleteMapping("/removeDish")
    @ApiOperation(value = "remove a dish from a store's menu",
            notes = "provide store id and dish id that need to be removed from the menu of" +
                    "that store.")
    public ResponseEntity<String> removeDish(@RequestParam String id, @RequestParam String dishId) {
        logger.info("API Request made to remove a dish from a menu");
        boolean isSuccess = storeService.removeDishToStoreMenu(id, dishId);
        if (!isSuccess) {
            return new ResponseEntity<>(
                    "Store with id: " + id + " or Dish with id: " + dishId + " does not exist.",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>(
                "Dish with id: " + dishId + " has been removed from store with id: " + id,
                HttpStatus.OK
        );
    }
}
