package com.THC.THCSpringBootAPI.controller;

import com.THC.THCSpringBootAPI.model.Address;
import com.THC.THCSpringBootAPI.model.Dish;
import com.THC.THCSpringBootAPI.model.Hour;
import com.THC.THCSpringBootAPI.model.THCStore;
import com.THC.THCSpringBootAPI.service.StoreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class THCStoreController {

    private static final Logger logger = LogManager.getLogger(LocationController.class);

    private final StoreService storeService;

    @Autowired
    public THCStoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public ResponseEntity<List<THCStore>> getStores() {
        logger.info("API Request made to get store list");
        List<THCStore> storesList = storeService.retrieveStoreList();
        return new ResponseEntity<>(storesList, HttpStatus.OK);
    }

    @PostMapping("/addnewstore")
    public ResponseEntity<String> addNewStore(@RequestBody THCStore thcStore) {
        logger.info("API Request made to add new store");
        THCStore newStore = storeService.addNewStore(thcStore);
        return new ResponseEntity<>("Store with id: " + newStore.getId() + " is created", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> removeStore(@RequestParam String id) {
        logger.info("API Request made to remove store");
        boolean isSuccess = storeService.removeStore(id);
        if (!isSuccess) {
            return new ResponseEntity<>("Store with id: " + id + " does not exist.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Store with id: " + id + " is removed", HttpStatus.OK);
    }

    @GetMapping(params = "id")
    public ResponseEntity<?> getStoreById(@RequestParam String id) {
        logger.info("API Request made to get store by id");
        THCStore store = storeService.getStoreById(id);
        if (store == null) {
            return new ResponseEntity<>("Store with id: " + id + " does not exist.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @PutMapping("/updateaddress")
    public ResponseEntity<String> updateAddress(@RequestParam String id, @RequestBody Address address) {
        logger.info("API Request made to update store's address");
        boolean isSuccess = storeService.updateStoreAddress(id, address);
        if (!isSuccess) {
            return new ResponseEntity<>("Store with id: " + id + " does not exist.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Store with id: " + id + " has new address now", HttpStatus.OK);
    }

    @PutMapping("/updatehour")
    public ResponseEntity<String> updateHour(@RequestParam String id, @RequestBody Hour hour) {
        logger.info("API Request made to update store's address");
        boolean isSuccess = storeService.updateStoreHours(id, hour);
        if (!isSuccess) {
            return new ResponseEntity<>("Store with id: " + id + " does not exist.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Store with id: " + id + " has new hours now", HttpStatus.OK);
    }

    @PostMapping("/updatemenu")
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

    @DeleteMapping("/updatemenu")
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
