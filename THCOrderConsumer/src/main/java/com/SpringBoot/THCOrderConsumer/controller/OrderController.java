package com.SpringBoot.THCOrderConsumer.controller;

import com.SpringBoot.THCOrderConsumer.model.Orders;
import com.SpringBoot.THCOrderConsumer.service.OrdersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public ResponseEntity<?> getAllOrders() {
        logger.info("Request received successfully");
        try {
            List<Orders> ordersList = ordersService.getAllOrders();
            if (ordersList.isEmpty()) {
                logger.info("No data found in database");
                return new ResponseEntity<>(ordersList, HttpStatus.NO_CONTENT);
            }
            logger.info("Request completed and data sent out");
            return new ResponseEntity<>(ordersList, HttpStatus.OK);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
