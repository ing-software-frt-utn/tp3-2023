package is.tp3;

import is.tp3.domain.Articulo;
import is.tp3.repositories.RepositorioArticulo;
import is.tp3.services.ServicioArticulo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ServicioBuscarArticuloTest {


    @Test
    public void elServicioDebePoderBuscarYRetornarUnArticuloTest(){



        RepositorioArticulo repositorioMock = mock(RepositorioArticulo.class);
        ServicioArticulo servicio = new ServicioArticulo(repositorioMock);


        Articulo esperado = new Articulo(123, "Lacoste", "Camisa", 1200.0, "Azul", "xl", 3, "sucursal");

        Articulo resultado;

        when(repositorioMock.buscarArticulo(anyInt()))
                .then(answer -> {
                    return new Articulo(123, "Lacoste", "Camisa", 1200.0, "Azul", "xl", 3, "sucursal");
                });

        resultado =  servicio.buscarArticulo(123);

        verify(repositorioMock);
        assertNotNull(resultado);

        assertEquals(esperado.getCodigo(), resultado.getCodigo());
        assertEquals(esperado.getPrecio(), resultado.getPrecio());
        assertEquals(esperado.getColor(), resultado.getColor());
        assertEquals(esperado.getTalle(), resultado.getTalle());
        assertEquals(esperado.getDescripcion(), resultado.getDescripcion());
        assertEquals(esperado.getMarca(), resultado.getMarca());

    }

}
