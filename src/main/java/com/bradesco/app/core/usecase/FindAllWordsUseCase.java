package com.bradesco.app.core.usecase;

import com.bradesco.app.core.boundary.FindAllWordsBoundary;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.core.usecase.util.log.LogFlow;
import com.bradesco.app.core.usecase.util.log.LogUtil;
import com.bradesco.app.exception.ErrorCodeSupplier;
import com.bradesco.app.exception.Exception;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class FindAllWordsUseCase {

    private final FindAllWordsBoundary findAllWordsBoundary;

    public List<Word> execute() {
        try {
            log.debug("Finding words in database");
            return findAllWordsBoundary.execute();
        } catch (Exception e) {
            Exception businessException = new Exception(ErrorCodeSupplier.MATRIX_005);
            LogUtil.builder(log, LogFlow.FIND_ALL_WORDS)
                    .errorCode(businessException.getErrorCode().getCode())
                    .errorCodeMessage(businessException.getMessage())
                    .build().logErrorJson(e);
            throw businessException;
        }
    }

}
