package com.SpringBoot.THCOrderConsumer.service;

import com.SpringBoot.THCOrderConsumer.model.Orders;

import java.util.List;

public interface OrdersService {

    void saveOrders(List<Orders> ordersList);

    List<Orders> getAllOrders();
}
