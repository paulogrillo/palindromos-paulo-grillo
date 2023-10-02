package com.bradesco.app.dataprovider.gateway.database.mapper;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.dataprovider.gateway.database.entity.MatrizEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class MatrizEntityMapper {

    public static final MatrizEntityMapper INSTANCE = Mappers.getMapper(MatrizEntityMapper.class);

    public abstract Matriz matrizEntityToMatriz(MatrizEntity matrizEntity);

    public abstract MatrizEntity matrizToMatrizEntity(Matriz Matriz);

}
