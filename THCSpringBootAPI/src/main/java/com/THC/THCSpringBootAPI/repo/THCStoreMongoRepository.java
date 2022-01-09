package com.THC.THCSpringBootAPI.repo;

import com.THC.THCSpringBootAPI.model.THCStore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface THCStoreMongoRepository extends MongoRepository<THCStore, String> {
}
