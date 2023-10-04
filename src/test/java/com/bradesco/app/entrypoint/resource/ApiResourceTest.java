package com.bradesco.app.entrypoint.resource;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.core.usecase.AddNewMatrizUseCase;
import com.bradesco.app.core.usecase.AddNewWordUseCase;
import com.bradesco.app.core.usecase.FindAllWordsUseCase;
import com.bradesco.app.core.usecase.FindPalindromeUseCase;
import com.bradesco.app.dto.MatrizResponse;
import com.bradesco.app.dto.WordResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ApiResourceTest {

    @InjectMocks
    private ApiResource apiResource;

    @Mock
    private AddNewWordUseCase addNewWordUseCase;

    @Mock
    private FindAllWordsUseCase findAllWordsUseCase;

    @Mock
    private AddNewMatrizUseCase addNewMatrizUseCase;

    @Mock
    private FindPalindromeUseCase findPalindromeUseCase;

    @Test
    public void given_call_When_find_palindromic_return_status_created() {
        MatrizResponse matrizResponse = new MatrizResponse();
        Word word = new Word();

        when(findPalindromeUseCase.execute(any())).thenReturn(word);

        ResponseEntity<WordResponse> response = apiResource.findPalindromic(matrizResponse);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void given_call_Then_return_status_created_matriz() {
        MatrizResponse matrizResponse = new MatrizResponse();
        Matriz matrizCreated = new Matriz();

        when(addNewMatrizUseCase.execute(any())).thenReturn(matrizCreated);

        ResponseEntity<MatrizResponse> response = apiResource.createMatriz(matrizResponse);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void given_call_Then_return_status_created_word() {
        WordResponse wordResponse = new WordResponse();
        Word wordCreated = new Word();

        when(addNewWordUseCase.execute(any())).thenReturn(wordCreated);

        ResponseEntity<WordResponse> response = apiResource.createWord(wordResponse);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void given_call_Then_return_status_ok() {
        List<Word> wordList = Collections.singletonList(new Word());

        when(findAllWordsUseCase.execute()).thenReturn(wordList);

        ResponseEntity<List<WordResponse>> response = apiResource.findAllWords();

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
