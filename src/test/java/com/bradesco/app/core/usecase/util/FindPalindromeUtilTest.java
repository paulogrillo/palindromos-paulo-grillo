package com.bradesco.app.core.usecase.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FindPalindromeUtilTest {

    @Test
    public void give_call_When_palindromo_Then_return_true() {
        assertFalse(PalindromeValidateUtil.isPalindromo("hello"));
        assertTrue(PalindromeValidateUtil.isPalindromo("tenet"));
    }

}