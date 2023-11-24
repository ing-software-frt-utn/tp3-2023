Feature: Agregar Articulo a una venta

  como: vendedor
  quiero: agregar articulos a una venta
  para: mostrar los articulos seleccionados por el cliente y conocer el monto total

Scenario: Agregar articulo
Given existe una venta en proceso
And un articulo con el siguente detalle
| codigo | marca | descripcion | precio |
| 1234   |  nike |    short    | 2000   |
And existen los siguientes talles y colores para el articulo en la sucursal
|codigo | talle | color | stock|
| 1234  |   S   | verde |   4  |
| 1234  |   M   | azul  |   5  |
When selecciona
| talle | color | stock|
|   S   | verde |   4  |
Then se agrega la seleccion a la linea de venta
And se muestra el sub total correspondiente