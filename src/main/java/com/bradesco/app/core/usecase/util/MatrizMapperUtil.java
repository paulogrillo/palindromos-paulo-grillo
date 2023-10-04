package com.bradesco.app.core.usecase.util;

import com.bradesco.app.exception.ErrorCodeSupplier;
import com.bradesco.app.exception.Exception;

import java.util.List;

public class MatrizMapperUtil {

    public static char[][] convertMatrizListToCharacterArray(List<List<String>> matrizList) {
        int numRows = matrizList.size();
        int numCols = numRows > 0 ? matrizList.get(0).size() : 0;

        char[][] matrizArray = new char[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            List<String> row = matrizList.get(i);
            for (int j = 0; j < numCols; j++) {
                if (row.get(j).length() == 1) {
                    matrizArray[i][j] = row.get(j).charAt(0);
                } else {
                    throw new Exception(ErrorCodeSupplier.MATRIX_002);
                }
            }
        }

        return matrizArray;
    }
}
