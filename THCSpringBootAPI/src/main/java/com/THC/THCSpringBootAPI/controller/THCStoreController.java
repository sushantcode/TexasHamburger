package com.THC.THCSpringBootAPI.controller;

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

    @GetMapping("/removestore")
    public ResponseEntity<String> removeStore(@RequestParam String id) throws Exception {
        logger.info("API Request made to add new store");
        boolean newStore = storeService.removeStore(id);
        return new ResponseEntity<>("Store with id: " + id + " is removed", HttpStatus.OK);
    }
}
