package com.bradesco.app.fixture;

import com.bradesco.app.core.model.Word;

import java.util.ArrayList;
import java.util.List;

public class WordFixture {

    public static Word load() {
      return   Word.builder()
                .matrizId("001")
                .words(List.of("AAASS", "EEEPPL", "SAALL"))
                .build();
    }


    public static List<Word> loadList(int size) {
        List<Word> wordList = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            wordList.add(Word.builder()
                    .matrizId("001")
                    .words(List.of("AAASS", "EEEPPL", "SAALL"))
                    .build());
        }
        return wordList;
    }


}
