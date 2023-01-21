package com.eldorado.hhzze.domain.repository;

import com.eldorado.hhzze.domain.model.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface AddressRepository extends MongoRepository<AddressEntity, UUID> {
}
