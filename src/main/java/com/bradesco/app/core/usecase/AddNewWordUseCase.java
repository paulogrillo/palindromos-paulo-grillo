package com.bradesco.app.core.usecase;

import com.bradesco.app.core.boundary.InsertWordBoundary;
import com.bradesco.app.core.model.Word;
import com.bradesco.app.core.usecase.util.log.LogFlow;
import com.bradesco.app.core.usecase.util.log.LogUtil;
import com.bradesco.app.exception.ErrorCodeSupplier;
import com.bradesco.app.exception.Exception;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddNewWordUseCase {

    private final InsertWordBoundary insertWordBoundary;

    public Word execute(final Word wordRequest) {
        try {
            log.info("inserting a word into the database [{}], [{}]", wordRequest.getMatrizId(), wordRequest.getWords());
            return insertWordBoundary.execute(wordRequest);
        } catch (Exception e) {
            Exception businessException = new Exception(ErrorCodeSupplier.MATRIX_001);
            LogUtil.builder(log, LogFlow.CREATE_WORD)
                    .errorCode(businessException.getErrorCode().getCode())
                    .errorCodeMessage(businessException.getMessage())
                    .build().logErrorJson(e);
            throw businessException;
        }
    }
}
