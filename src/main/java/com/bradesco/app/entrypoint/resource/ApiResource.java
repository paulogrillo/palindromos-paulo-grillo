package com.bradesco.app.entrypoint.resource;

import com.bradesco.app.api.ApiApiDelegate;
import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.core.usecase.AddNewMatrizUseCase;
import com.bradesco.app.core.usecase.AddNewWordUseCase;
import com.bradesco.app.core.usecase.FindAllWordsUseCase;
import com.bradesco.app.core.usecase.FindPalindromeUseCase;
import com.bradesco.app.dto.MatrizResponse;
import com.bradesco.app.dto.WordResponse;
import com.bradesco.app.entrypoint.mapper.MatrizResponseMapper;
import com.bradesco.app.entrypoint.mapper.WordResponseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ApiResource implements ApiApiDelegate {

    private final AddNewWordUseCase addNewWordUseCase;
    private final FindAllWordsUseCase findAllWordsUseCase;
    private final AddNewMatrizUseCase addNewMatrizUseCase;
    private final FindPalindromeUseCase findPalindromeUseCase;

    @Override
    public ResponseEntity<WordResponse> findPalindromic(MatrizResponse matrizResponse) {

        final Word word = findPalindromeUseCase.execute(MatrizResponseMapper
                .INSTANCE.convertMatrizResponseToMatriz(matrizResponse));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(WordResponseMapper.
                        INSTANCE.convertWordToWordResponse(word));
    }

    @Override
    public ResponseEntity<MatrizResponse> createMatriz(MatrizResponse matrizResponse) {
        final Matriz matriz = MatrizResponseMapper.INSTANCE.convertMatrizResponseToMatriz(matrizResponse);
        final Matriz matrizCreated = addNewMatrizUseCase.execute(matriz);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MatrizResponseMapper
                        .INSTANCE.convertMatrizToMatrizResponse(matrizCreated));
    }

    @Override
    public ResponseEntity<WordResponse> createWord(final WordResponse wordResponse) {
        final Word word = WordResponseMapper.INSTANCE.convertWordResponseToWord(wordResponse);
        final Word wordCreated = addNewWordUseCase.execute(word);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(WordResponseMapper
                        .INSTANCE.convertWordToWordResponse(wordCreated));
    }

    @Override
    public ResponseEntity<List<WordResponse>> findAllWords() {
        final List<Word> wordList = findAllWordsUseCase.execute();

        return ResponseEntity.ok(WordResponseMapper.INSTANCE.convertWordListToWordResponseList(wordList));
    }
}
