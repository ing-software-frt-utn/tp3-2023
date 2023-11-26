package adapter;

import domain.Venta;

public interface AdaptadorVenta {
    Boolean SolicitarAutorizacionVentaAFIP(Venta venta);
    Boolean RecibirResultadoAFIP(String resultado);
}
