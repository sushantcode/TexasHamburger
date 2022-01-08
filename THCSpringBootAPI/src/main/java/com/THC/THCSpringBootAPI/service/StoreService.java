package com.THC.THCSpringBootAPI.service;

import com.THC.THCSpringBootAPI.model.THCStore;

import java.util.List;

public interface StoreService {

    // services for high level store chain operations
    List<THCStore> retrieveStoreList();
    THCStore addNewStore(THCStore thcStore);
    boolean removeStore(String id);

    // services for updating particular store information
    THCStore getStoreById(String id);
    boolean updateStoreAddress(String id);
    boolean updateStoreHours(String id);
    boolean addDishToStoreMenu(String id);
    boolean removeDishToStoreMenu(String storeId, String dishId);
}
