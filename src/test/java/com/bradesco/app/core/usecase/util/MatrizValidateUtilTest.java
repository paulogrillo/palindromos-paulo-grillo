package com.bradesco.app.core.usecase.util;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.fixture.MatrizFixture;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatrizValidateUtilTest {

    @Test
    public void given_call_When_is_square_matriz_Then_return_true() {
        Matriz matriz = MatrizFixture.loadValidMatriz(5);
        assertTrue(MatrizValidateUtil.isSquareMatriz(matriz));
    }

    @Test
    public void given_call_When_is_not_square_matriz_Then_return_false() {
        Matriz matriz = Matriz.builder()
                .matrizId("matriz2")
                .matriz(Arrays.asList(
                        Arrays.asList("Z", "Z", "Z"),
                        Arrays.asList("Z", "Z"),
                        Arrays.asList("Z", "Z", "Z")
                ))
                .build();
        assertFalse(MatrizValidateUtil.isSquareMatriz(matriz));
    }

    @Test
    public void give_call_When_exceed_max_colluns_return_false() {
        Matriz matriz = Matriz.builder()
                .matrizId("matriz3")
                .matriz(Arrays.asList(
                        Arrays.asList("A", "B"),
                        Arrays.asList("A", "E"),
                        Arrays.asList("A", "H"),
                        Arrays.asList("A", "J"),
                        Arrays.asList("A", "L"),
                        Arrays.asList("M", "N"),
                        Arrays.asList("O", "P"),
                        Arrays.asList("Q", "R"),
                        Arrays.asList("S", "T"),
                        Arrays.asList("U", "V"),
                        Arrays.asList("W", "X")
                ))
                .build();

        assertFalse(MatrizValidateUtil.isSquareMatriz(matriz));
    }

    @Test
    public void give_call_When_matriz_square_non_Letter_return_false() {
        Matriz matriz = Matriz.builder()
                .matrizId("matriz4")
                .matriz(Arrays.asList(
                        Arrays.asList("z", "z", "z"),
                        Arrays.asList("z", "z", "1"),
                        Arrays.asList("z", "z", "z")
                ))
                .build();

        assertFalse(MatrizValidateUtil.isSquareMatriz(matriz));
    }

}