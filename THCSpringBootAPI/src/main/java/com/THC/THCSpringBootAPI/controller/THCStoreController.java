package com.THC.THCSpringBootAPI.controller;

import com.THC.THCSpringBootAPI.model.THCStore;
import com.THC.THCSpringBootAPI.repo.THCStoreRepository;
import com.THC.THCSpringBootAPI.service.StoreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class THCStoreController {

    private static final Logger logger = LogManager.getLogger(LocationController.class);

    private StoreService storeService;

    @Autowired
    public THCStoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<THCStore> getStores() {
        logger.info("API Request made to get store list");

        return storeService.retrieveStoreList();
    }

    @PostMapping("/addnewstore")
    public THCStore addNewStore(@RequestBody THCStore thcStore) {
        logger.info("API Request made to add new store");
        return storeService.addNewStore(thcStore);
    }
}
