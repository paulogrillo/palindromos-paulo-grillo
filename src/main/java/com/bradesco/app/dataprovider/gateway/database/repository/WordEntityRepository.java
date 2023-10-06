package com.bradesco.app.dataprovider.gateway.database.repository;

import com.bradesco.app.dataprovider.gateway.database.entity.WordEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordEntityRepository extends MongoRepository<WordEntity, String> {
}
