package com.bradesco.app.core.usecase.util;

import java.util.List;

public class PalindromeValidateUtil {

    public static boolean hasPalindromo(List<List<String>> matriz) {
        if (matriz == null || matriz.isEmpty()) {
            return false;
        }

        int numRows = matriz.size();
        int numCols = matriz.get(0).size();

        for (List<String> row : matriz) {
            for (String item : row) {
                if (isPalindromo(item)) {
                    return true;
                }
            }
        }

        for (int col = 0; col < numCols; col++) {
            StringBuilder columnStr = new StringBuilder();
            for (int row = 0; row < numRows; row++) {
                columnStr.append(matriz.get(row).get(col));
            }
            if (isPalindromo(columnStr.toString())) {
                return true;
            }
        }

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                StringBuilder diagonalStr = new StringBuilder();
                int r = row, c = col;
                while (r < numRows && c < numCols) {
                    diagonalStr.append(matriz.get(r).get(c));
                    r++;
                    c++;
                }
                if (isPalindromo(diagonalStr.toString())) {
                    return true;
                }
            }
        }

        for (int row = 0; row < numRows; row++) {
            for (int col = numCols - 1; col >= 0; col--) {
                StringBuilder diagonalStr = new StringBuilder();
                int r = row, c = col;
                while (r < numRows && c >= 0) {
                    diagonalStr.append(matriz.get(r).get(c));
                    r++;
                    c--;
                }
                if (isPalindromo(diagonalStr.toString())) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isPalindromo(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}


