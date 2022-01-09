package com.THC.THCSpringBootAPI.service.Implementation;

import com.THC.THCSpringBootAPI.controller.LocationController;
import com.THC.THCSpringBootAPI.model.Orders;
import com.THC.THCSpringBootAPI.model.Reservation;
import com.THC.THCSpringBootAPI.repo.THCStoreMysqlOrderRepository;
import com.THC.THCSpringBootAPI.repo.THCStoreMysqlReservationRepository;
import com.THC.THCSpringBootAPI.service.TransactionalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransactionalServiceImplementation implements TransactionalService {

    private static final Logger logger = LogManager.getLogger(LocationController.class);

    @Autowired
    private THCStoreMysqlOrderRepository thcStoreMysqlOrderRepository;

    @Autowired
    private THCStoreMysqlReservationRepository thcStoreMysqlReservationRepository;

    @Override
    public List<Reservation> getReservations() {

        return null;
    }

    @Override
    public Reservation getReservationByStore(String storeId) {
        return null;
    }

    @Override
    public Reservation createNewReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation getReservationById(String reservationId) {
        return null;
    }

    @Override
    public boolean removeReservation(String reservationId) {
        return false;
    }

    @Override
    public boolean modifyReservation(String reservationId) {
        return false;
    }

    @Override
    public List<Orders> getOrders() {
        return null;
    }

    @Override
    public Orders getOrderByStore(String storeId) {
        return null;
    }

    @Override
    public Orders createNewOrder(Orders orders) {
        return null;
    }

    @Override
    public Orders getOrderById(String orderId) {
        return null;
    }

    @Override
    public boolean removeOrder(String orderId) {
        return false;
    }

    @Override
    public boolean modifyOrder(String orderId) {
        return false;
    }
}
