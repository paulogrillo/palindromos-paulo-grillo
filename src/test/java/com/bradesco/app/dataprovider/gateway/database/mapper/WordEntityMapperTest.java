package com.bradesco.app.dataprovider.gateway.database.mapper;

import com.bradesco.app.core.model.Word;
import com.bradesco.app.dataprovider.gateway.database.entity.WordEntity;
import com.bradesco.app.fixture.WordEntityFixture;
import com.bradesco.app.fixture.WordFixture;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WordEntityMapperTest {

    @Test
    void given_a_wordEntity_When_call_mapper_Then_return_word() {
        final WordEntityMapper mapper = WordEntityMapper.INSTANCE;
        final WordEntity wordEntity = WordEntityFixture.load();

        final Word word = mapper.wordEntityToWord(wordEntity);

        assertThat(word).isNotNull();
        assertThat(word.getMatrizId()).isEqualTo(wordEntity.getMatrizId());
        assertThat(word.getWords()).isEqualTo(wordEntity.getWords());
    }

    @Test
    void given_a_word_When_call_mapper_Then_return_wordEntity() {
        final WordEntityMapper mapper = WordEntityMapper.INSTANCE;
        final Word word = WordFixture.load();

        final WordEntity wordEntity = mapper.wordToWordEntity(word);

        assertThat(wordEntity).isNotNull();
        assertThat(wordEntity.getMatrizId()).isEqualTo(word.getMatrizId());
        assertThat(wordEntity.getWords()).isEqualTo(word.getWords());
    }

}