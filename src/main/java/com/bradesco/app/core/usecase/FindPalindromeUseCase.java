package com.bradesco.app.core.usecase;

import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.core.usecase.util.FindPalindromeUtil;
import com.bradesco.app.core.usecase.util.MatrizValidateUtil;
import com.bradesco.app.core.usecase.util.PalindromeValidateUtil;
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

        List<List<String>> matrizStrings = matriz.getMatriz();
        char[][] matrix = new char[matrizStrings.size()][matrizStrings.get(0).size()];

        for (int i = 0; i < matrizStrings.size(); i++) {
            List<String> row = matrizStrings.get(i);
            for (int j = 0; j < row.size(); j++) {
                String element = row.get(j);
                if (element.length() != 1) {
                    throw new Exception(ErrorCodeSupplier.MATRIX_002);
                }
                matrix[i][j] = element.charAt(0);
            }
        }

            matriz.setMatrizId(UUID.randomUUID().toString());
            Word word = Word.builder()
                    .matrizId(matriz.getMatrizId())
                    .build();


            List<String> wordsPalindromicToSave = new ArrayList<>();

            wordsPalindromicToSave = FindPalindromeUtil.findPalindromes(matrix);
            word.setWords(wordsPalindromicToSave);

            log.info("| palindromes found | x = [{}] | y = [{}] | z = [{}]",
                    wordsPalindromicToSave.get(0),
                    wordsPalindromicToSave.get(1),
                    wordsPalindromicToSave.get(2));

            return addNewWordUseCase.execute(word);
    }
}
