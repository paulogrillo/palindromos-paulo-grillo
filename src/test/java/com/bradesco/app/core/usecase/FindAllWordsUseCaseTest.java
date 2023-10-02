package com.bradesco.app.core.usecase;

import com.bradesco.app.core.boundary.FindAllWordsBoundary;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.exception.ErrorCodeSupplier;
import com.bradesco.app.exception.Exception;
import com.bradesco.app.fixture.WordFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllWordsUseCaseTest {

    @InjectMocks
    private FindAllWordsUseCase findAllWordsUseCase;

    @Mock
    private FindAllWordsBoundary findAllWordsBoundary;

    @Test
    void give_call_usecase_Then_return_wordlist() {

        List<Word> wordList = WordFixture.loadList(10);

        when(findAllWordsBoundary.execute()).thenReturn(wordList);

        List<Word> boundaryWordList = findAllWordsUseCase.execute();

        assertThat(boundaryWordList).isNotNull();
        assertThat(boundaryWordList).isNotEmpty().hasSize(10);
        assertThat(boundaryWordList.get(0).getWords().get(0)).isEqualTo(wordList.get(0).getWords().get(0));

    }

    @Test
    void give_call_usecase_When_called_with_error_Then_return_exception() {

        when(findAllWordsBoundary.execute()).thenThrow(Exception.class);

        final Exception businessException = assertThrows(Exception.class, () -> findAllWordsUseCase.execute());

        verify(findAllWordsBoundary).execute();
        assertThat(businessException.getErrorCode()).isEqualTo(ErrorCodeSupplier.MATRIX_005);
        assertThat(businessException.getMessage()).isEqualTo(ErrorCodeSupplier.MATRIX_005.getMessage());

    }

}