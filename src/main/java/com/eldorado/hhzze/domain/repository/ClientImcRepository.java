package com.eldorado.hhzze.domain.repository;

import com.eldorado.hhzze.domain.model.ClientImcEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ClientImcRepository extends MongoRepository<ClientImcEntity, UUID> {

    List<ClientImcEntity> findByClientId(UUID clientId);
}
