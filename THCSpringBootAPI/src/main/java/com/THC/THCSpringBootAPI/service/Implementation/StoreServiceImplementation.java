package com.THC.THCSpringBootAPI.service.Implementation;

import com.THC.THCSpringBootAPI.controller.LocationController;
import com.THC.THCSpringBootAPI.model.Address;
import com.THC.THCSpringBootAPI.model.Dish;
import com.THC.THCSpringBootAPI.model.Hour;
import com.THC.THCSpringBootAPI.model.THCStore;
import com.THC.THCSpringBootAPI.repo.THCStoreMongoRepository;
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
    private THCStoreMongoRepository thcStoreMongoRepository;

    @Override
    public List<THCStore> retrieveStoreList() {
        try {
            return thcStoreMongoRepository.findAll();
        } catch (MongoException e) {
            throw e;
        }
    }

    @Override
    public THCStore addNewStore(THCStore thcStore) {
        return thcStoreMongoRepository.save(thcStore);
    }

    @Override
    public boolean removeStore(String storeId) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            thcStoreMongoRepository.deleteById(storeId);
            return true;
        }
        return false;
    }

    @Override
    public THCStore getStoreById(String storeId) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            return thcStoreMongoRepository.findById(storeId).get();
        }
        return null;
    }

    @Override
    public boolean updateStoreAddress(String storeId, Address address) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            THCStore thcStore = thcStoreMongoRepository.findById(storeId).get();
            thcStore.setAddress(address);
            thcStoreMongoRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStoreHours(String storeId, Hour hour) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            THCStore thcStore = thcStoreMongoRepository.findById(storeId).get();
            thcStore.setHour(hour);
            thcStoreMongoRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public boolean addDishToStoreMenu(String storeId, Dish dish) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            THCStore thcStore = thcStoreMongoRepository.findById(storeId).get();
            thcStore.getMenu().getDishes().add(dish);
            thcStoreMongoRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDishToStoreMenu(String storeId, String dishId) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            THCStore thcStore = thcStoreMongoRepository.findById(storeId).get();
            Dish dish = thcStore.getMenu().getDishes()
                        .stream()
                        .filter(dis -> dis.getId().equals(dishId)).findFirst().orElse(null);
            if (dish == null) {
                return false;
            }
            thcStore.getMenu().getDishes().remove(dish);
            thcStoreMongoRepository.save(thcStore);
            return true;
        }
        return false;
    }
}
