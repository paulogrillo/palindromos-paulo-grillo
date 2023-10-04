package com.bradesco.app.core.usecase;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.core.usecase.util.FindPalindromeUtil;
import com.bradesco.app.core.usecase.util.MatrizMapperUtil;
import com.bradesco.app.core.usecase.util.MatrizValidateUtil;
import com.bradesco.app.exception.ErrorCodeSupplier;
import com.bradesco.app.exception.Exception;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class FindPalindromeUseCase {

    private final AddNewWordUseCase addNewWordUseCase;

    public Word execute(Matriz matriz) {

        if (StringUtils.isEmpty(matriz.getMatriz().toString()) || !MatrizValidateUtil.isSquareMatriz(matriz)) {
            throw new Exception(ErrorCodeSupplier.MATRIX_002);
        }

        char[][] matrizArray = MatrizMapperUtil.convertMatrizListToCharacterArray(matriz.getMatriz());
        List<String> wordsPalindromicToSave = new ArrayList<>();


        wordsPalindromicToSave = FindPalindromeUtil.findPalindromes(matrizArray);
        log.info("| palindromes found | x = [{}] | y = [{}] | z = [{}]",
                wordsPalindromicToSave.get(0),
                wordsPalindromicToSave.get(1),
                wordsPalindromicToSave.get(2));

        Word word = Word.builder()
                .matrizId(UUID.randomUUID().toString())
                .words(wordsPalindromicToSave)
                .build();

        return addNewWordUseCase.execute(word);
    }
}
