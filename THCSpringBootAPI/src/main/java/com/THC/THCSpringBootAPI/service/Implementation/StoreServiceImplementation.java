package com.THC.THCSpringBootAPI.service.Implementation;

import com.THC.THCSpringBootAPI.model.*;
import com.THC.THCSpringBootAPI.repo.THCStoreMongoRepository;
import com.THC.THCSpringBootAPI.service.StoreService;
import com.mongodb.MongoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreServiceImplementation implements StoreService {

    private static final Logger logger = LogManager.getLogger(StoreServiceImplementation.class);

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
            thcStore.getMenu().add(dish);
            thcStoreMongoRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeDishToStoreMenu(String storeId, String dishId) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            THCStore thcStore = thcStoreMongoRepository.findById(storeId).get();
            Dish dish = thcStore.getMenu()
                        .stream()
                        .filter(dis -> dis.getId().equals(dishId)).findFirst().orElse(null);
            if (dish == null) {
                return false;
            }
            thcStore.getMenu().remove(dish);
            thcStoreMongoRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public List<Reservation> getAllReservations(String storeId) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            return thcStoreMongoRepository.findById(storeId).get().getReservationList();
        }
        return null;
    }

    @Override
    public boolean createNewReservation(String storeId, Reservation reservation) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            THCStore thcStore = thcStoreMongoRepository.findById(storeId).get();
            thcStore.getReservationList().add(reservation);
            thcStoreMongoRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public Reservation getReservationById(String storeId, String reservationId) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            Reservation reservation = thcStoreMongoRepository.findById(storeId).get()
                                        .getReservationList()
                                        .stream()
                                        .filter(reserve -> reserve.getId().equals(reservationId))
                                        .findFirst()
                                        .orElse(null);
            return reservation;
        }
        return null;
    }

    @Override
    public boolean removeReservation(String storeId, String reservationId) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            THCStore thcStore = thcStoreMongoRepository.findById(storeId).get();
            Reservation reservation = thcStore.getReservationList()
                                        .stream()
                                        .filter(reserve -> reserve.getId().equals(reservationId))
                                        .findFirst()
                                        .orElse(null);
            if (reservation == null) {
                return false;
            }
            thcStore.getReservationList().remove(reservation);
            thcStoreMongoRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifyReservation(String storeId, String reservationId, Reservation reservation) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            THCStore thcStore = thcStoreMongoRepository.findById(storeId).get();
            Reservation oldReservation = thcStore.getReservationList()
                                        .stream()
                                        .filter(reserve -> reserve.getId().equals(reservationId))
                                        .findFirst()
                                        .orElse(null);
            if (oldReservation == null) {
                return false;
            }
            thcStore.getReservationList().remove(oldReservation);
            reservation.setId(reservationId);
            thcStore.getReservationList().add(reservation);
            thcStoreMongoRepository.save(thcStore);
            return true;
        }
        return false;
    }

    @Override
    public boolean createNewOrder(String storeId, Orders orders) {
        try {
            if (thcStoreMongoRepository.existsById(storeId)) {
                THCStore thcStore = thcStoreMongoRepository.findById(storeId).get();
                orders.setStoreId(storeId);
                thcStore.getOrdersList().add(orders);
                thcStoreMongoRepository.save(thcStore);
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.info("Cannot create new order because " + e.toString());
            throw e;
        }
    }

    @Override
    public List<Orders> getAllOrders(String storeId) {
        if (thcStoreMongoRepository.existsById(storeId)) {
            THCStore thisStore = thcStoreMongoRepository.findById(storeId).get();
            List<Orders> allOrders = new ArrayList<>(thisStore.getOrdersList());
            thisStore.getOrdersList().clear();
            thcStoreMongoRepository.save(thisStore);
            return allOrders;
        }
        return null;
    }
}
