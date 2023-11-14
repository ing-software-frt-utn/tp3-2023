Feature: Agregar articulos a venta
  Como vendedor
  Quiero agregar artículos a las ventas
  Para registrar las compras de los clientes y conocer el total de la venta

  Scenario: Agregar articulo a la venta con exito
    Given una venta en proceso
    And un articulo con codigo 1234 con los siguientes datos:
      | Descripcion      | Marca  | Categoria  | Precio |
      | Zapatillas altas | Adidas | Zapatillas | 1000   |
    And el inventario disponible para una combinacion de talles y colores para la sucursal "centro" es la siguiente:
      | Color  | Talle | Cantidad |
      | Blanco | 38    | 10       |
      | Negro  | 40    | 5        |
      | Rojo   | 38    | 8        |
    When selecciono con cantidad "1" la siguiente combinacion:
      | Talle | Color |
      | 38    | Rojo  |
    Then la linea de venta sera de la siguiente manera:
      | Cantidad | Codigo | Descripcion      | Talle | Color | PrecioUnitario | Subtotal |
      | 1        | 1234   | Zapatillas altas | 38    | Rojo  | 1000           | 1000     |
    And el total de la venta sera 1000 .