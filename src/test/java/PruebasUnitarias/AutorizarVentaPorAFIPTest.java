package PruebasUnitarias;
import domain.EstadoVenta;
import domain.Venta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutorizarVentaPorAFIPTest {

    Venta venta = new Venta();

    @Test
    public void ventaAprobadaPorAFIP(){

        venta.AutorizacionAFIP(true);

        assertEquals(EstadoVenta.APROBADA,venta.getEstadoVenta());
    }

    @Test
    public void ventaRechazadaPorAFIP(){

        venta.AutorizacionAFIP(false);

        assertEquals(EstadoVenta.RECHAZADA, venta.getEstadoVenta());
    }

}
