package com.THC.THCSpringBootAPI.repo;

import com.THC.THCSpringBootAPI.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface THCStoreMysqlReservationRepository extends CrudRepository<Reservation, String> {
}
