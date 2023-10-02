package com.bradesco.app.core.model;

public class PalindromeModel {

    private String palavra;

    public PalindromeModel(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    @Override
    public String toString() {
        return palavra;
    }
}