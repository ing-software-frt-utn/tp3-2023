Feature: Verificar Cliente

  como vendedor
  quiero iniciar una venta
  para cargar articulos posteriormente

  Scenario: Inicio de una venta
    Given un cliente
      |  nombre  |    dni   | condicion tributaria |
      | generico | 11111111 |         CF           |
    When se inicia una nueva venta
    Then se asocia a la venta el cliente con dni '11111111'

