package com.THC.THCSpringBootAPI.repo;

import com.THC.THCSpringBootAPI.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface THCStoreMysqlOrderRepository extends CrudRepository<Orders, String> {
}
