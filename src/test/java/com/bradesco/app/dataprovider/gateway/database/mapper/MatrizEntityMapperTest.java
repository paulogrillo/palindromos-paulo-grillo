package com.bradesco.app.dataprovider.gateway.database.mapper;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.dataprovider.gateway.database.entity.MatrizEntity;
import com.bradesco.app.fixture.MatrizEnityFixture;
import com.bradesco.app.fixture.MatrizFixture;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatrizEntityMapperTest {

    @Test
    void given_a_matrizEntity_When_call_mapper_Then_return_matriz() {
        final MatrizEntityMapper mapper = MatrizEntityMapper.INSTANCE;
        final MatrizEntity matrizEntity = MatrizEnityFixture.loadList(5);

        final Matriz matriz = mapper.matrizEntityToMatriz(matrizEntity);

        assertThat(matriz).isNotNull();
        assertThat(matriz.getMatriz().indexOf(0)).isEqualTo(matrizEntity.getMatriz().indexOf(0));
    }

    @Test
    void given_a_matriz_When_call_mapper_Then_return_matrizEntity() {
        final MatrizEntityMapper mapper = MatrizEntityMapper.INSTANCE;
        final Matriz matriz = MatrizFixture.loadValidMatriz(5);

        final MatrizEntity matrizEntity = mapper.matrizToMatrizEntity(matriz);

        assertThat(matrizEntity).isNotNull();
        assertThat(matrizEntity.getMatriz().indexOf(0)).isEqualTo(matriz.getMatriz().indexOf(0));

    }

}