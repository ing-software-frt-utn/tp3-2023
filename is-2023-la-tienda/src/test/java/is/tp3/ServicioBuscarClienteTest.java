package is.tp3;

import is.tp3.domain.Articulo;
import is.tp3.repositories.RepositorioArticulo;
import is.tp3.services.ServicioBuscarArticulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ServicioBuscarClienteTest {

    @Test
    public void buscarYEncontrarUnArticuloPorCodigo(){
        RepositorioArticulo repositorioMock = mock(RepositorioArticulo.class);
        ServicioBuscarArticulo servicio = new ServicioBuscarArticulo(repositorioMock);
        Integer codigo = 123;

        when(repositorioMock.buscarArticulo(anyInt()))
                .then(answer -> {
            return new Articulo(answer.getArgument(0), null, null, 0d);
        });

        Articulo articulo = servicio.buscarArticulo(codigo);

        verify(repositorioMock);
        assertNotNull(articulo);
        assertTrue(articulo.tieneCodigo(codigo));
    }
}
