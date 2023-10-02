package com.bradesco.app.dataprovider.gateway.database.impl;

import com.bradesco.app.core.boundary.InsertMatrizBoundary;
import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.dataprovider.gateway.database.entity.MatrizEntity;
import com.bradesco.app.dataprovider.gateway.database.mapper.MatrizEntityMapper;
import com.bradesco.app.repository.MatrizEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class InsertMatrizDbGateway implements InsertMatrizBoundary {

    private final MatrizEntityRepository matrizEntityRepository;

    @Override
    public Matriz execute(Matriz matriz) {
        final MatrizEntity matrizEntity = matrizEntityRepository.save(MatrizEntityMapper.INSTANCE.matrizToMatrizEntity(matriz));
        return MatrizEntityMapper.INSTANCE.matrizEntityToMatriz(matrizEntity);
    }
}
