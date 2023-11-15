Feature: Buscar Cliente
#   COMO vendedor
#   QUIERO buscar un cliente
#   PARA identificarlo
#   Y agregarlo a una venta.

  Background:
    Given que existen los siguientes Clientes con sus dni:

      |       nombre      |       dni     |
      |Juan Perez         |37890124       |
      |Gabriel Arias      |45796823       |

#   Prueba 1

  Scenario: Búsqueda exitosa de Cliente no anónimo


    When busco un cliente con dni: 37890124
    Then el Cliente "Juan Perez" se asocia a la Venta
