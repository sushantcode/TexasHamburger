package com.THC.THCSpringBootAPI.service;

import com.THC.THCSpringBootAPI.model.*;

import java.util.List;

public interface StoreService {

    // services for high level store chain operations
    List<THCStore> retrieveStoreList();
    THCStore addNewStore(THCStore thcStore);
    boolean removeStore(String storeId);

    // services for updating particular store information
    THCStore getStoreById(String storeId);
    boolean updateStoreAddress(String storeId, Address address);
    boolean updateStoreHours(String storeId, Hour hour);
    boolean addDishToStoreMenu(String storeId, Dish dish);
    boolean removeDishToStoreMenu(String storeId, String dishId);
}
