package com.SpringBoot.THCOrderConsumer.service.Implementation;

import com.SpringBoot.THCOrderConsumer.model.Dish;
import com.SpringBoot.THCOrderConsumer.model.Orders;
import com.SpringBoot.THCOrderConsumer.repositroy.OrdersConsumerRepository;
import com.SpringBoot.THCOrderConsumer.service.OrdersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImplementation implements OrdersService {

    private static final Logger logger = LogManager.getLogger(OrdersServiceImplementation.class);

    @Autowired
    private OrdersConsumerRepository ordersConsumerRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    @KafkaListener(topics = "orders", groupId = "OrdersConsumerID1")
    public void saveOrders(List<Orders> ordersList) {
        for (int i = 0; i < ordersList.size(); i++) {
            Orders order = objectMapper.convertValue(ordersList.get(i), Orders.class);
            logger.info(order);
            for (Dish dish : order.getItems()) {
                dish.setOrderId(order.getId());
            }
            ordersConsumerRepository.save(order);
        }
    }

    @Override
    public List<Orders> getAllOrders() {
        return (List<Orders>) ordersConsumerRepository.findAll();
    }
}
