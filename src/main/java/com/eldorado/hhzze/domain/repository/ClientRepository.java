package com.eldorado.hhzze.domain.repository;

import com.eldorado.hhzze.domain.model.ClientEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ClientRepository extends MongoRepository<ClientEntity, UUID> {
}
