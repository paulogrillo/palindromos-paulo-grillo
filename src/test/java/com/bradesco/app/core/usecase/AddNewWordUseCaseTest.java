package com.bradesco.app.core.usecase;

import com.bradesco.app.core.boundary.InsertWordBoundary;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.fixture.WordFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddNewWordUseCaseTest {

    @InjectMocks
    AddNewWordUseCase addNewWordUseCase;

    @Mock
    InsertWordBoundary insertWordBoundary;

    @Test
    void given_a_call_When_create_a_word_Then_return_word_created() {
        Word wordRequest = WordFixture.load();

        when(insertWordBoundary.execute(any())).thenReturn(wordRequest);

        final Word wordResult = addNewWordUseCase.execute(wordRequest);

        verify(insertWordBoundary).execute(any());
        assertThat(wordResult).isNotNull();
        assertThat(wordResult.getMatrizId()).isEqualTo(wordRequest.getMatrizId());
        assertThat(wordResult.getWords()).isEqualTo(wordRequest.getWords());
    }

    @Test
    void given_a_call_When_word_already_exists_Then_return_exception() {
        // To do
    }

}