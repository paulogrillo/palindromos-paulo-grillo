package com.bradesco.app.entrypoint.mapper;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.dto.MatrizResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class MatrizResponseMapper {

    public static final MatrizResponseMapper INSTANCE = Mappers.getMapper(MatrizResponseMapper.class);

    public abstract MatrizResponse convertMatrizToMatrizResponse(Matriz matriz);

    public abstract Matriz convertMatrizResponseToMatriz(MatrizResponse matrizResponse);

}
