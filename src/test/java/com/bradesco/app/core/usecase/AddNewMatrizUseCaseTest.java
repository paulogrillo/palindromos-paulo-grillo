package com.bradesco.app.core.usecase;

import com.bradesco.app.core.boundary.InsertMatrizBoundary;
import com.bradesco.app.core.model.Matriz;
import com.bradesco.app.fixture.MatrizFixture;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddNewMatrizUseCaseTest {

    @InjectMocks
    private AddNewMatrizUseCase addNewMatrizUseCase;

    @Mock
    private InsertMatrizBoundary insertMatrizBoundary;

    @Test
    public void testExecuteWithValidMatriz() {
        Matriz matriz = MatrizFixture.loadInvalidMatriz(5);

        when(insertMatrizBoundary.execute(any(Matriz.class))).thenReturn(matriz);

        Matriz result = addNewMatrizUseCase.execute(matriz);

        verify(insertMatrizBoundary, times(1)).execute(any(Matriz.class));

        assertNotNull(result);
        assertEquals(matriz.getMatrizId(), result.getMatrizId());
    }

    @Test
    public void testExecuteWithEmptyMatriz() {
        Matriz matriz = new Matriz();
        matriz.setMatrizId("123");
        matriz.setMatriz(null);

        assertThrows(Exception.class, () -> addNewMatrizUseCase.execute(matriz));
    }


    @Test
    public void testExecuteWithEmptyMatrizId() {
        Matriz matriz = MatrizFixture.loadInvalidMatriz(5);
        matriz.setMatrizId(null);

        assertThrows(Exception.class, () -> addNewMatrizUseCase.execute(matriz));
    }

}