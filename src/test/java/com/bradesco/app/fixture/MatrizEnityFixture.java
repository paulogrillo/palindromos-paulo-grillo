package com.bradesco.app.fixture;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.dataprovider.gateway.database.entity.MatrizEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MatrizEnityFixture {

    public static MatrizEntity loadList(int size) {
        List<List<String>> matriz = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            matriz.add(Arrays.asList("TENET", "TENET", "TENET", "TENET", "TENET"));
        }
        return MatrizEntity.builder()
                .matrizId(UUID.randomUUID().toString())
                .matriz(matriz)
                .build();

    }

}
