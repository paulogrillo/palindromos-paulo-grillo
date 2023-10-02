package com.bradesco.app.core.usecase.util;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.fixture.MatrizFixture;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeValidateUtilTest {

    @Test
    public void give_call_When_has_palindromo_in_matriz_Then_return_true() {
        List<List<String>> matriz = Arrays.asList(
                Arrays.asList("radar", "hello", "world"),
                Arrays.asList("java", "kayak", "palindrome"),
                Arrays.asList("level", "noon", "civic")
        );
        assertTrue(PalindromeValidateUtil.hasPalindromo(matriz));
    }

    @Test
    public void give_call_When_without_palindromo_in_matriz_Then_return_false() {
        List<List<String>> matriz = Arrays.asList(
                Arrays.asList("apple", "banana", "cherry"),
                Arrays.asList("dog", "cat", "fish"),
                Arrays.asList("moon", "sun", "star")
        );

        assertFalse(PalindromeValidateUtil.hasPalindromo(matriz));
    }

    @Test
    public void give_call_When_has_valid_palindromo_in_matriz_Then_return_true() {
        assertTrue(PalindromeValidateUtil.isPalindromo("radar"));
        assertTrue(PalindromeValidateUtil.isPalindromo("A man a plan a canal Panama"));
    }
}