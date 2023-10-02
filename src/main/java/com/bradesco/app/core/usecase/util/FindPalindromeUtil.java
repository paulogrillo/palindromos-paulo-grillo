package com.bradesco.app.core.usecase.util;

import com.bradesco.app.exception.ErrorCodeSupplier;
import com.bradesco.app.exception.Exception;

import java.util.ArrayList;
import java.util.List;

public class FindPalindromeUtil {

    public static List<String> findPalindromes(char[][] matrix) {
        List<String> palindromes = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                StringBuilder horizontal = new StringBuilder();
                StringBuilder vertical = new StringBuilder();
                for (int k = 0; k < cols; k++) {
                    if (j + k < cols) {
                        horizontal.append(matrix[i][j + k]);
                    }
                    if (i + k < rows) {
                        vertical.append(matrix[i + k][j]);
                    }
                }
                if (isPalindrome(horizontal.toString())) {
                    palindromes.add(horizontal.toString());
                }
                if (isPalindrome(vertical.toString())) {
                    palindromes.add(vertical.toString());
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                StringBuilder diagonal1 = new StringBuilder();
                StringBuilder diagonal2 = new StringBuilder();
                for (int k = 0; k < rows && i + k < rows && j + k < cols; k++) {
                    diagonal1.append(matrix[i + k][j + k]);
                }
                for (int k = 0; k < rows && i + k < rows && j - k >= 0; k++) {
                    diagonal2.append(matrix[i + k][j - k]);
                }
                if (isPalindrome(diagonal1.toString())) {
                    palindromes.add(diagonal1.toString());
                }
                if (isPalindrome(diagonal2.toString())) {
                    palindromes.add(diagonal2.toString());
                }
            }
        }
        palindromes.removeIf(s -> s.length() < rows - 1);

        if(palindromes.isEmpty()){
          throw new Exception(ErrorCodeSupplier.MATRIX_002);
        }

        return palindromes;
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

