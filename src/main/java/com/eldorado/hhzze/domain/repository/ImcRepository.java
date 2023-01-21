package com.eldorado.hhzze.domain.repository;

import com.eldorado.hhzze.domain.model.ImcEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ImcRepository extends MongoRepository<ImcEntity, UUID> {
}
