Feature: el proceso de Pago
  El proceso de pago que se realiza en la venta en curso que puede llegar a ser menor o mayor a $92.720,00 con o sin factura.

  Scenario: Realizar el pago menor a $92.720,00 sin factura
    Given Que existe un cliente que realiza una compra de $10000.00 con id "50" de un producto "remera" talle "M" color "Azul" con id "255"
    When se realiza el pago de la compra con idCompra "50" de $10000.00
    Then El Sistema registra el pago para la compra con id "50"
    And El sistema calcula, muestra el vuelto $0.00

  Scenario: Realizar el pago mayor a $92.720,00
    Given que existe un cliente con dni "36665599", nombre "Juan", domicilio "san Miguel de tucuman" que realiza una compra de $120000.00 con id "89" de "6" productos "remeras" talle "M" color "Amarillo" con id "256"
    When se realiza el pago de la compra con idCompra "89" de $121000.00
    Then El sistema asocia el cliente con dni "36665599", nombre "Juan", domicilio "san Miguel de tucuman" a la compra con idCompra "89"
    And  El sistema se conecta con el sistema externo de AFIP el cual aprueba compra con id "89"
    And  El Sistema registra el pago para la compra con id "89"
    And  El sistema calcula, muestra el vuelto $1000.00
