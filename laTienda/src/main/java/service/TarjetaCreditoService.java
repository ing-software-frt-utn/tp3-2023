package service;

import is.tp3.domain.TarjetaCredito;
import repository.TarjetaCreditoRepository;

public class TarjetaCreditoService implements TarjetaCreditoRepository{
    @Override
    public String solicitudDeAprobacionDePago(TarjetaCredito tarjeta, Double monto) {
        //llamo a la api magicamente
        return "Pago aprobado";
    }
}
