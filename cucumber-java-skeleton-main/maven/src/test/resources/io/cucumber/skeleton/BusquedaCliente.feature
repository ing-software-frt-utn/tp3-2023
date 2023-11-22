Feature: Buscar Cliente por DNI
    Como vendedor
    Quiero buscar un cliente registrado por DNI
    Para iniciar la venta

    Scenario: Cliente encontrado
        Given una venta iniciada
        When ingreso el "<dni>" DNI del cliente registrado
        Then muestra el cliente por "<nombre>" nombre y "<condicion tributaria>" condición tributaria
            | dni      | nombre   | condicion tributaria |
            | 38116114 | Matias   | monotributista       |

    Scenario: Cliente no encontrado
        Given una venta iniciada
        When ingreso el DNI del cliente registrado
        Then muestra que el cliente no está registrado