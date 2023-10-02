package com.bradesco.app.repository;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.dataprovider.gateway.database.entity.MatrizEntity;
import com.bradesco.app.dataprovider.gateway.database.entity.WordEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatrizEntityRepository extends MongoRepository<MatrizEntity, String> {
}
