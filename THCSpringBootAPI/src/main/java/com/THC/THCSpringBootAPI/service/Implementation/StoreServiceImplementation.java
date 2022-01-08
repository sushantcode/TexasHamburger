package com.THC.THCSpringBootAPI.service.Implementation;

import com.THC.THCSpringBootAPI.controller.LocationController;
import com.THC.THCSpringBootAPI.model.Address;
import com.THC.THCSpringBootAPI.model.Dish;
import com.THC.THCSpringBootAPI.model.Hour;
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
        return thcStoreRepository.save(thcStore);
    }

    @Override
    public boolean removeStore(String id) {
        if (thcStoreRepository.existsById(id)) {
            thcStoreRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public THCStore getStoreById(String id) {
        if (thcStoreRepository.existsById(id)) {
            return thcStoreRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean updateStoreAddress(String id, Address address) {
        if (thcStoreRepository.existsById(id)) {
            THCStore thcStore = thcStoreRepository.findById(id).get();
            thcStore.setAddress(address);
            thcStoreRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStoreHours(String id, Hour hour) {
        if (thcStoreRepository.existsById(id)) {
            THCStore thcStore = thcStoreRepository.findById(id).get();
            thcStore.setHour(hour);
            thcStoreRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public boolean addDishToStoreMenu(String id, Dish dish) {
        if (thcStoreRepository.existsById(id)) {
            THCStore thcStore = thcStoreRepository.findById(id).get();
            thcStore.getMenu().getDishes().add(dish);
            thcStoreRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDishToStoreMenu(String storeId, String dishId) {
        if (thcStoreRepository.existsById(storeId)) {
            THCStore thcStore = thcStoreRepository.findById(storeId).get();
            Dish dish = thcStore.getMenu().getDishes()
                        .stream()
                        .filter(dis -> dis.getId().equals(dishId)).findFirst().orElse(null);
            if (dish == null) {
                return false;
            }
            thcStore.getMenu().getDishes().remove(dish);
            thcStoreRepository.save(thcStore);
            return true;
        }
        return false;
    }
}
