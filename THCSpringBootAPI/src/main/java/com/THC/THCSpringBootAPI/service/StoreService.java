package com.THC.THCSpringBootAPI.service;

import com.THC.THCSpringBootAPI.model.Address;
import com.THC.THCSpringBootAPI.model.Dish;
import com.THC.THCSpringBootAPI.model.Hour;
import com.THC.THCSpringBootAPI.model.THCStore;

import java.util.List;

public interface StoreService {

    // services for high level store chain operations
    List<THCStore> retrieveStoreList();
    THCStore addNewStore(THCStore thcStore);
    boolean removeStore(String id);

    // services for updating particular store information
    THCStore getStoreById(String id);
    boolean updateStoreAddress(String id, Address address);
    boolean updateStoreHours(String id, Hour hour);
    boolean addDishToStoreMenu(String id, Dish dish);
    boolean removeDishToStoreMenu(String storeId, String dishId);
}
