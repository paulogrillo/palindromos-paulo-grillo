package com.bradesco.app.core.usecase;

import com.bradesco.app.core.boundary.InsertMatrizBoundary;
import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.core.usecase.util.MatrizValidateUtil;
import com.bradesco.app.exception.ErrorCodeSupplier;
import com.bradesco.app.exception.Exception;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AddNewMatrizUseCase {

    private final InsertMatrizBoundary insertMatrizBoundary;

    public Matriz execute(Matriz matrizRequest) {

        log.info("Inserting matriz in database matrizId: [{}], matriz: [{}]",
                matrizRequest.getMatrizId(), matrizRequest.getMatriz());

        if (!StringUtils.isEmpty(matrizRequest.getMatriz().toString())
                && matrizRequest.getMatriz() != null
                && !StringUtils.isEmpty(matrizRequest.getMatrizId())) {
            return insertMatrizBoundary.execute(matrizRequest);
        }
        throw new Exception(ErrorCodeSupplier.MATRIX_002);
    }
}