Feature: comprobar existencia de un articulo
  Como vendedor
  Quiero verificar la disponibilidad de un articulo
  Para agregarlo a la venta

Scenario: Error al buscar articulo inexistente
  Given una venta en proceso
  Given el siguiente articulo
  | Codigo | Marca  | Descripcion    | Precio |
  | 124    | Adidas | Indumentaria   | 30000  |
  When ingresa el codigo 1234
  Then se muestra mensaje de error