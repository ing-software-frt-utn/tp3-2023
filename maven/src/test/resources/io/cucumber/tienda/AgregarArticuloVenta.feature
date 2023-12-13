Feature: Agregar Articulo a una venta

  como: vendedor
  quiero: agregar articulos a una venta
  para: mostrar los articulos seleccionados por el cliente y conocer el monto total

Scenario: Agregar articulo
Given existe una venta en proceso
And un articulo con el siguente detalle codigo "1234", marca "nike", descripcion "short", precio "2000"
And existen los siguientes talles y colores para el articulo en la sucursal talle "s", color "verde", stock "4"
When selecciona talle "s", color "verde", stock "4"
Then se agrega la seleccion a la linea de venta
And se muestra el sub total correspondiente

