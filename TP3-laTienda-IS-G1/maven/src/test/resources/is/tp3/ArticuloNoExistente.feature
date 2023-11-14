Feature: comprobar existencia de un articulo
  Como vendedor
  Quiero verificar la disponibilidad de un articulo
  Para agregarlo a la venta

Scenario: Error al agregar articulo inexistente
Given una venta en proceso
When ingreso el codigo 1234
Then se muestra mensaje de error "Articulo no existente"