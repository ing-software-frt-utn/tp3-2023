Feature: Asociar Cliente
  Como Vendedor
  Quiero Asociar un cliente a una venta
  Para Modificar los datos asociados a la venta

  Scenario Outline:  Se modifica el tipo de comprobante asociado a la venta dependiendo de la condición tributaria del cliente.
    Given un cliente con condicion tributaria "Consumidor Final"
    And una venta con el cliente asociado
    When modifico la condicion tributaria del cliente asociado a la venta a "<cond_tributaria>"
    Then se modifica en la venta el tipo de comprobante a "<tipo_comprobante>"

    Examples:

      |    cond_tributaria		  |  tipo_comprobante  |
      |   Responsable Inscripto   |     Factura A      |
      |   Monotributista		  |     Factura A      |
      |   Exento				  |     Factura B      |
      |   No Responsable 		  |     Factura B      |
