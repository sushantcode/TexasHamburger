package com.THC.THCSpringBootAPI.controller;

import com.THC.THCSpringBootAPI.model.Orders;
import com.THC.THCSpringBootAPI.model.Reservation;
import com.THC.THCSpringBootAPI.service.StoreService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrdersController {
    private static final Logger logger = LogManager.getLogger(OrdersController.class);

    private final StoreService storeService;

    @Autowired
    public OrdersController(StoreService storeService) {
        this.storeService = storeService;
    }

    private static final String KAFKA_TOPIC = "orders";

    @Autowired
    private KafkaTemplate<String, List<Orders>> kafkaTemplate;

    @GetMapping("/all")
    @ApiOperation(value = "send daily orders list to Kafka stream",
            notes = "provide store id to send its daily list of orders to kafka which then be " +
                    "consumed by the consumer.")
    public ResponseEntity<?> pushDayOrdersToKafka(@ApiParam(value = "Store Id",
            required = true, defaultValue = "") @RequestParam String id) {
        logger.info("API Request made to push all orders for a day");
        List<Orders> ordersList = storeService.getAllOrders(id);
        if (ordersList == null) {
            return new ResponseEntity<>(
                    "Store with id: " + id + " does not exist or there is not orders in database.",
                    HttpStatus.NOT_FOUND
            );
        }
        kafkaTemplate.send(KAFKA_TOPIC, ordersList);
        return new ResponseEntity<>("Order collection pushed to kafka", HttpStatus.OK);
    }

    @PostMapping("/create")
    @ApiOperation(value = "create new order for a location",
            notes = "provide store id and Orders object to be added to the database.")
    public ResponseEntity<String> createNewOrder(@ApiParam(value = "Store Id",
            required = true, defaultValue = "") @RequestParam String id, @RequestBody Orders orders) {
        logger.info("API Request made to add new order");
        boolean isSuccess = storeService.createNewOrder(id, orders);
        if (!isSuccess) {
            return new ResponseEntity<>(
                    "Store with id: " + id + " does not exist.",
                    HttpStatus.NOT_FOUND
            );
        }
        return new ResponseEntity<>("Order with id: " + orders.getId() + " is added", HttpStatus.CREATED);
    }
}
