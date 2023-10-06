package com.bradesco.app.fixture;

import com.bradesco.app.dto.WordResponse;

import java.util.List;

public class WordResponseFixture {

    public static WordResponse load(){
        return new WordResponse().words(List.of("OSSS", "TENET"));
    }
}
