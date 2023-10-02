package com.bradesco.app.dataprovider.gateway.database.impl;

import com.bradesco.app.core.model.Word;
import com.bradesco.app.dataprovider.gateway.database.entity.WordEntity;
import com.bradesco.app.fixture.WordEntityFixture;
import com.bradesco.app.fixture.WordFixture;
import com.bradesco.app.repository.WordEntityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith({MockitoExtension.class})
class InsertWordDbGatewayTest {

    @InjectMocks
    InsertWordDbGateway insertWordDbGateway;

    @Mock
    WordEntityRepository wordEntityRepository;

    @Test
    void given_success_When_call_resporitory_and_save() {
        final Word word = WordFixture.load();
        final WordEntity wordEntity = WordEntityFixture.load();

        when(wordEntityRepository.save(any())).thenReturn(wordEntity);

        final Word wordResponse = insertWordDbGateway.execute(word);

        verify(wordEntityRepository).save(any());

        assertThat(wordResponse).isNotNull();
        assertThat(wordResponse.getMatrizId()).isEqualTo(wordEntity.getMatrizId());
        assertThat(wordResponse.getWords()).isEqualTo(wordEntity.getWords());
    }

}