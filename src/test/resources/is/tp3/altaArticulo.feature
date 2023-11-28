Feature: Agregar articulos a la venta



  Scenario: Se agrega un articulo a la venta

    Given que hay un artículo con los siguientes atributos:
      | Codigo | Marca | Descripcion | Precio | Color | Talle | Stock | Sucursal |
      |  123   | Lacoste | Camisa    | 1200.0   | Azul  | xl  | 5   | Sucursal1  |


    And hay una venta en curso

    When se agregan 2 unidades del articulo con codigo 123

    Then se crea en la venta una linea de venta con el articulo de codigo: 123, color: "Azul", talle: "xl" y cantidad: 2

    And el total de la venta se incrementa en 2400.0
