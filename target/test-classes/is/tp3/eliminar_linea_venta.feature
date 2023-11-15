Feature: Eliminar Linea de Venta

#   COMO Vendedor
#   QUIERO eliminar la Línea de Venta
#   PARA poder actualizar la lista de artículos que el cliente desea adquirir

  Scenario: quitar un articulo de una venta

    Given una venta en curso en la sucursal: "Sucursal1" con dos articulos con los siguientes datos:

      | Codigo | Marca | Descripcion | Precio   | Color |Talle|Stock|
      |  123   | Lacoste | Camisa    | 1200.0   | Azul  | xl  |  3  |
      |  124   | Adidas  | Camiseta  | 1500.0   | Negro | s   |  4  |

    And cantidad del articulo de codigo 123 es igual a 2
    And cantidad del articulo de codigo 124 es igual a 1


    When se elimina el articulo con codigo 124

    Then la linea de venta del articulo con codigo 124 se elimina
    And se actualiza el total de la venta en 2400.0