package com.bradesco.app.fixture;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.dataprovider.gateway.database.entity.MatrizEntity;
import com.bradesco.app.dto.MatrizResponse;
import com.bradesco.app.dto.WordResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MatrizResponseFixture {

    public static MatrizResponse loadValidMatriz() {
        List<List<String>> matriz = new ArrayList<>();
        matriz.add(Arrays.asList("A", "O", "S", "S", "O"));
        matriz.add(Arrays.asList("Y", "R", "Z", "X", "L"));
        matriz.add(Arrays.asList("J", "S", "A", "P", "M"));
        matriz.add(Arrays.asList("J", "K", "P", "R", "Z"));
        matriz.add(Arrays.asList("Y", "L", "E", "R", "A"));

        MatrizResponse response = new MatrizResponse();
        response.setMatrizId(UUID.randomUUID().toString());
        response.setMatriz(matriz);

        return response;
    }
}
