package service;

import is.tp3.domain.SolicitudAutorizacionPago;
import repository.TarjetaCreditoRepository;

public class TarjetaCreditoService implements TarjetaCreditoRepository{
    @Override
    public String solicitudDeAprobacionDePago(SolicitudAutorizacionPago solicitud) {
        return "Aprobado";
    }
}
