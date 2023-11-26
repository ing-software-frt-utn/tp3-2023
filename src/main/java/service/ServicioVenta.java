package service;
import adapter.AdaptadorVenta;
import domain.Venta;

public class ServicioVenta implements AdaptadorVenta {

    private final AdaptadorVenta adaptadorVenta;

    public ServicioVenta(AdaptadorVenta adaptadorVenta) {
        this.adaptadorVenta = adaptadorVenta;
    }

    @Override
    public Boolean SolicitarAutorizacionVentaAFIP(Venta venta) {
        return adaptadorVenta.SolicitarAutorizacionVentaAFIP(venta);
    }

    @Override
    public Boolean RecibirResultadoAFIP(String respuesta) {
        return adaptadorVenta.RecibirResultadoAFIP(respuesta);
    }
}
