package repositorie;

import domain.Venta;


public interface IRepositorioVenta {

    Boolean SolicitarAutorizacionVentaAFIP(Venta venta);
    Venta RecibirResultadoAFIP(String resultado);
}
