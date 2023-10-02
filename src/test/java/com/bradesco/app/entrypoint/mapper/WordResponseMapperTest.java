package com.bradesco.app.entrypoint.mapper;

import com.bradesco.app.core.model.Word;
import com.bradesco.app.dto.WordResponse;
import com.bradesco.app.fixture.WordFixture;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WordResponseMapperTest {

    public static WordResponseMapper mapper = WordResponseMapper.INSTANCE;

    @Test
    void given_a_word_When_call_mapper_Then_return_wordResponse() {
        Word word = WordFixture.load();

        final WordResponse wordResponse = mapper.convertWordToWordResponse(word);

        assertThat(wordResponse).isNotNull();
        assertThat(wordResponse.getMatrizId()).isEqualTo(word.getMatrizId());
        assertThat(wordResponse.getWords()).isEqualTo(word.getWords());
    }

    @Test
    void given_a_wordResponse_When_call_mapper_Then_return_word() {
        WordResponse wordResponse = new WordResponse();

        final Word word = mapper.convertWordResponseToWord(wordResponse);

        assertThat(word).isNotNull();
        assertThat(word.getMatrizId()).isEqualTo(wordResponse.getMatrizId());
        assertThat(word.getWords()).isEqualTo(wordResponse.getWords());
    }

    @Test
    void given_a_word_list_When_call_mapper_Then_return_wordResponse() {
        List<Word> wordList = WordFixture.loadList(5);

        final List<WordResponse> wordResponseList = mapper.convertWordListToWordResponseList(wordList);

        assertThat(wordResponseList).isNotNull();
        assertThat(wordResponseList.get(0).getMatrizId()).isEqualTo(wordList.get(0).getMatrizId());
        assertThat(wordResponseList.get(0).getWords()).isEqualTo(wordList.get(0).getWords());
    }
}