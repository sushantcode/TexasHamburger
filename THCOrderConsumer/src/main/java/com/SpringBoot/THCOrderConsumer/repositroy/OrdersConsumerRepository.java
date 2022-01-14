package com.SpringBoot.THCOrderConsumer.repositroy;

import com.SpringBoot.THCOrderConsumer.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersConsumerRepository extends JpaRepository<Orders, String> {
}
