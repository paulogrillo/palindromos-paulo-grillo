package com.bradesco.app.core.usecase;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.exception.ErrorCodeSupplier;
import com.bradesco.app.exception.Exception;
import com.bradesco.app.fixture.MatrizFixture;
import com.bradesco.app.fixture.WordFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindPalindromeUseCaseTest {

    @InjectMocks
    private FindPalindromeUseCase findPalindromeUseCase;

    @Mock
    private AddNewWordUseCase addNewWordUseCase;

    @Test
    public void give_call_When_is_valid_square_matriz_Then_return_result() throws Exception {
        Word word = WordFixture.load();
        Matriz matriz = MatrizFixture.loadValidMatriz(5);

        when(addNewWordUseCase.execute(any())).thenReturn(word);

        Word result = findPalindromeUseCase.execute(matriz);

        verify(addNewWordUseCase, times(1)).execute(any());
        assertNotNull(result);
        assertThat(result.getWords().get(0)).isEqualTo(word.getWords().get(0));
    }

    @Test
    public void give_call_When_is_empty_or_non_square_matriz_return_throws_exception() {
        Matriz matriz = new Matriz();
        matriz.setMatrizId(null);
        matriz.setMatriz(Arrays.asList());

        final Exception businessException = assertThrows(Exception.class, () -> findPalindromeUseCase.execute(matriz));
        assertThat(businessException.getErrorCode()).isEqualTo(ErrorCodeSupplier.MATRIX_002);
        assertThat(businessException.getMessage()).isEqualTo(ErrorCodeSupplier.MATRIX_002.getMessage());
    }


    @Test
    public void give_call_When_is_not_fund_palindromo_in_square_matriz_Then_return_throws_exception() {
        Matriz matriz = MatrizFixture.loadInvalidMatriz(5);

        final Exception businessException = assertThrows(Exception.class, () -> findPalindromeUseCase.execute(matriz));
        assertThat(businessException.getErrorCode()).isEqualTo(ErrorCodeSupplier.MATRIX_002);
        assertThat(businessException.getMessage()).isEqualTo(ErrorCodeSupplier.MATRIX_002.getMessage());
    }

}