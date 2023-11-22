Feature: Iniciar Venta
    Como vendedor
    Quiero empezar una nueva venta
    Para comenzar la carga de artículos a la venta

    Scenario: Iniciar venta con cliente consumidor final
        Given un cliente con nombre "<Nombre>" y condición tributaria "consumidor final" con DNI "<DNI>"
        When el vendedor inicia una nueva venta para el cliente con condición tributaria "consumidor final"
        Then la nueva venta está asociada a los datos del cliente nuevo
            | Nombre         | DNI      | Condicion Tributaria |
            | Matias Alicata | 38116114 | Consumidor final     |
