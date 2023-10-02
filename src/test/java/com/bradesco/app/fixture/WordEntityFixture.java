package com.bradesco.app.fixture;

import com.bradesco.app.dataprovider.gateway.database.entity.WordEntity;

import java.util.ArrayList;
import java.util.List;

public class WordEntityFixture {

    public static WordEntity load() {
        return WordEntity.builder()
                .matrizId("002")
                .words(List.of("ASSO", "AAAA")).build();
    }

    public static List<WordEntity> loadList(int size) {
        List<WordEntity> wordEntityList = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            wordEntityList.add(WordEntity.builder()
                    .matrizId("001")
                    .words(List.of("AAASS", "EEEPPL", "SAALL"))
                    .build());
        }
        return wordEntityList;
    }
}
