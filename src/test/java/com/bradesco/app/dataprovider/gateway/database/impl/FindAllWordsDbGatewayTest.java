package com.bradesco.app.dataprovider.gateway.database.impl;

import com.bradesco.app.core.model.Word;
import com.bradesco.app.dataprovider.gateway.database.entity.WordEntity;
import com.bradesco.app.fixture.WordEntityFixture;
import com.bradesco.app.dataprovider.gateway.database.repository.WordEntityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class FindAllWordsDbGatewayTest {

    @InjectMocks
    FindAllWordsDbGateway findAllWordsDbGateway;

    @Mock
    WordEntityRepository wordEntityRepository;

    @Test
    void given_find_words_When_call_gateway_Then_return_converted_list_from_wordEntity_to_word() {

        List<WordEntity> wordEntityListFixture = WordEntityFixture.loadList(5);

        when(wordEntityRepository.findAll()).thenReturn(wordEntityListFixture);

        List<Word> wordEntityList = findAllWordsDbGateway.execute();

        verify(wordEntityRepository).findAll();

        assertThat(wordEntityList).isNotNull();
        assertThat(wordEntityList).isNotEmpty().hasSize(5);
        assertThat(wordEntityList.get(0).getMatrizId()).isEqualTo(wordEntityList.get(0).getMatrizId());
        assertThat(wordEntityList.get(0).getWords()).isEqualTo(wordEntityList.get(0).getWords());
    }

}