Feature: Verificar Disponibilidad
  Como vendedor
  Quiero agregar articulos a la venta
  Para reflejar la selección del cliente

Scenario: Cantidad de stock insuficiente
  Given una venta en proceso
  And existen las siguientes combinaciones para el articulo ingresado
    | Codigo | Talle | Color | Cantidad |
    | 1222   | L     | azul  | 1        |
  When ingreso cantidad igual a 3
  Then muestra un mensaje "Cantidad insuficiente del articulo"