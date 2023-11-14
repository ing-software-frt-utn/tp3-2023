package repository;

import is.tp3.domain.TarjetaCredito;

public interface TarjetaCreditoRepository {
    String solicitudDeAprobacionDePago(TarjetaCredito tarjeta, Double monto);
}
