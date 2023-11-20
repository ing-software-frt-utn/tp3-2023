package service;
import domain.Venta;
import repositorie.IRepositorioVenta;

public class ServicioVenta implements IRepositorioVenta {

    private final IRepositorioVenta repositorio;

    public ServicioVenta(IRepositorioVenta repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Boolean SolicitarAutorizacionVentaAFIP(Venta venta) {
        return repositorio.SolicitarAutorizacionVentaAFIP(venta);
    }

    @Override
    public Venta RecibirResultadoAFIP(String respuesta) {
        return repositorio.RecibirResultadoAFIP(respuesta);
    }
}
