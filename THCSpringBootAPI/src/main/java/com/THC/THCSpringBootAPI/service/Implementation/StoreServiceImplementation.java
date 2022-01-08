package com.THC.THCSpringBootAPI.service.Implementation;

import com.THC.THCSpringBootAPI.controller.LocationController;
import com.THC.THCSpringBootAPI.model.THCStore;
import com.THC.THCSpringBootAPI.repo.THCStoreRepository;
import com.THC.THCSpringBootAPI.service.StoreService;
import com.mongodb.MongoException;
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
        try {
            return thcStoreRepository.findAll();
        } catch (MongoException e) {
            throw e;
        }
    }

    @Override
    public THCStore addNewStore(THCStore thcStore) {
        try {
            return thcStoreRepository.save(thcStore);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean removeStore(String id) throws Exception {
        if (thcStoreRepository.findById(id) != null) {
            thcStoreRepository.deleteById(id);
            return true;
        } else {
            throw new Exception("Not Found");
        }
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
