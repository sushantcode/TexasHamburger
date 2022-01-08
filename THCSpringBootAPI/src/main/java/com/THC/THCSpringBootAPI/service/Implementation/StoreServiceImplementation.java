package com.THC.THCSpringBootAPI.service.Implementation;

import com.THC.THCSpringBootAPI.controller.LocationController;
import com.THC.THCSpringBootAPI.model.THCStore;
import com.THC.THCSpringBootAPI.repo.THCStoreRepository;
import com.THC.THCSpringBootAPI.service.StoreService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImplementation implements StoreService {

    private static final Logger logger = LogManager.getLogger(LocationController.class);

    @Autowired
    private THCStoreRepository thcStoreRepository;

    @Override
    public List<THCStore> retrieveStoreList() {
        return thcStoreRepository.findAll();
    }

    @Override
    public THCStore addNewStore(THCStore thcStore) {
        return thcStoreRepository.save(thcStore);
    }

    @Override
    public boolean removeStore(String id) {
        return false;
    }

    @Override
    public THCStore getStoreById(String id) {
        return null;
    }

    @Override
    public boolean updateStoreAddress(String id) {
        return false;
    }

    @Override
    public boolean updateStoreHours(String id) {
        return false;
    }

    @Override
    public boolean addDishToStoreMenu(String id) {
        return false;
    }

    @Override
    public boolean removeDishToStoreMenu(String storeId, String dishId) {
        return false;
    }
}
