package com.THC.THCSpringBootAPI.repo;

import com.THC.THCSpringBootAPI.model.THCStore;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface THCStoreRepository extends MongoRepository<THCStore, String> {
}
