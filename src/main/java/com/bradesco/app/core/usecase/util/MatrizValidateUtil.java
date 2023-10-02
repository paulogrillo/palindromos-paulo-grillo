package com.bradesco.app.core.usecase.util;

import com.bradesco.app.core.model.Matriz;

import java.util.List;

public class MatrizValidateUtil {

    public static boolean isSquareMatriz(Matriz matriz) {

        List<List<String>> matrizData = matriz.getMatriz();
        int rows = matrizData.size();

        if (rows < 2 || rows > 10) {
            return false;
        }

        int cols = matrizData.get(0).size();
        for (List<String> linha : matrizData) {
            if (linha.size() != cols) {
                return false;
            }
        }

        return matrizData.stream()
                .flatMap(List::stream)
                .allMatch(item -> item.matches("^[a-zA-Z]*$"));
    }
}

