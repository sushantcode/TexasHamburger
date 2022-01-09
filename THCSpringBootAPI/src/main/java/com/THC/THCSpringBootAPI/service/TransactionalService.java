package com.THC.THCSpringBootAPI.service;

import com.THC.THCSpringBootAPI.model.Orders;
import com.THC.THCSpringBootAPI.model.Reservation;

import java.util.List;

public interface TransactionalService {

    // services for reservation operation
    List<Reservation> getReservations();
    Reservation getReservationByStore(String storeId);
    Reservation createNewReservation(Reservation reservation);
    Reservation getReservationById(String reservationId);
    boolean removeReservation(String reservationId);
    boolean modifyReservation(String reservationId);

    // services for ordering operation
    List<Orders> getOrders();
    Orders getOrderByStore(String storeId);
    Orders createNewOrder(Orders orders);
    Orders getOrderById(String orderId);
    boolean removeOrder(String orderId);
    boolean modifyOrder(String orderId);
}
