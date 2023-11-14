#noinspection SpellCheckingInspection
Feature: Pago en Efectivo
  Como    Vendedor
  Quiero  Registrar el metodo de pago en efectivo
  Para    Asociar un cliente a la venta "y registrar el pago"

    # Prueba 1
  Scenario: Pago en efectivo con monto total mayor a 92.700 y un cliente por defecto asociado.
    Given la venta con la siguiente informacion:
      | Total  | Cliente Asociado |
      | 100000 | 00000000         |
    When selecciono el metodo de pago en efectivo
    And quiero finalizar la venta
    Then se muestra el mensaje "ERROR. Debido a que el monto total es mayor a $92.700, debe asociar un cliente a la venta."


    # Prueba 2- Outline
  Scenario Outline: Pago en Efectivo y asociacion de cliente.
    Given la venta con la siguiente informacion:
      | Total        | Cliente Asociado |
      | <montoTotal> | <dniCliente>     |
    When selecciono el metodo de pago en efectivo
    And quiero finalizar la venta
    Then la venta contiene la siguiente informacion:
      |  Total         | Cliente Asociado     | Metodo de Pago |
      |  <montoTotal>  |     <dniCliente>     |    Efectivo    |

    Examples:
      | montoTotal | dniCliente |
      | 90000      | 0          |
      | 90000      | 12345678   |
      | 100000     | 12345678   |
