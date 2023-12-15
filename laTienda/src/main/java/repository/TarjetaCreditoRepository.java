package repository;

import is.tp3.domain.SolicitudAutorizacionPago;
import is.tp3.domain.TarjetaCredito;

public interface TarjetaCreditoRepository {
    String solicitudDeAprobacionDePago(SolicitudAutorizacionPago solicitud);
}
