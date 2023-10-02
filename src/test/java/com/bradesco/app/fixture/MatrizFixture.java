package com.bradesco.app.fixture;

import com.bradesco.app.core.model.Matriz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MatrizFixture {

    public static Matriz loadValidMatriz(int size) {
        List<List<String>> matriz = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            matriz.add(Arrays.asList("A", "O", "S", "S", "O"));
        }
        return Matriz.builder()
                .matrizId(UUID.randomUUID().toString())
                .matriz(matriz)
                .build();

    }

    public static Matriz loadInvalidMatriz(int size) {
        List<List<String>> matriz = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            matriz.add(Arrays.asList("TZN", "TZNET", "TZNET", "TZNT", "TZNET"));
        }
        return Matriz.builder()
                .matrizId(UUID.randomUUID().toString())
                .matriz(matriz)
                .build();

    }
}
