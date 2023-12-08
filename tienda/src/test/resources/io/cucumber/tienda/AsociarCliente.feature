Feature: Asociar Cliente
  Como vendedor
  Quiero definir un cliente en la venta
  Para reconocer el tipo de comprobante

  Scenario: Se modifica el cliente por defecto asociado a la venta por uno ya existente con condicion tributaria diferente
  Given una venta en proceso con el cliente por defecto:
        |      DNI       |    NOMBRE   | CONDICION_TRIBUTARIA  |
        |     0          |   Defecto   |    Consumidor Final   |
  And un cliente registrado con los datos:
        |      DNI       |  NOMBRE  | CONDICION_TRIBUTARIA  |
        |     43654213   |   Juan Perez   | Responsable Inscripto |
  When asocio al cliente con DNI "43654213" a la venta
  Then me queda la venta asociada al cliente "Juan Perez" y el tipo de comprobante es "Factura A"