public class ReglaDeDescuento {
    private static final double porcentajeMenor = 0.03d;
    private static final double porcentajeIntermedio = 0.05d;
    private static final double porcentajeMayor = 0.10d;

    public double Calcular(double total) {
        if(total <= 0)
            throw new IllegalArgumentException("El total debe ser mayor a 0");

        if (total > 5000 && total <= 10000) {
            return total * porcentajeMenor;
        }
        if (total > 10000 && total <= 25000) {
            return total * porcentajeIntermedio;
        }
        else if (total > 25000) {
            return total * porcentajeMayor;
        }
        return 0;
    }
}


/*
------- Tenemos 4 features -------

- Escenarios Feature 1 -> Buscar producto:
    Buscar productos existentes
    Buscar productos inexistentes
    Productos con stock en algunos productos y otros no

- Escenarios Feature 2 -> Agregar producto a linea de venta:
    Seleccionar productos ingresó cantidad existente
    Seleccionar productos ingresó cantidad insuficiente
    Seleccionar productos ingresó cantidad no existente
    Seleccionar producto previamente agregado

- Escenarios Feature 3 -> Calculo del total:
    Calculo de total exitoso
    Calculo de total cuando se agrega una linea de venta
    Calculo de total cuando se modifica una linea de venta
    Calculo de total cuando se quita una linea de venta

- Escenarios Feature 4 -> Pago con tarjeta:
    Pago con tarjeta valida
    Pago con tarjeta inexistente
    Pago con tarjeta vencida
    Pago con tarjeta erronea
 */
