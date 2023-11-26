Feature: Buscar articulo
  Como vendedor
  Quiero buscar un articulo
  Para conocer su stock

  Scenario: Buscar articulo exitosamente
    Given el siguiente articulo
      | Codigo | Marca | Categoria | Precio   |
      | 1234   | Nike  | Zapatilla | 15000.00 |
    And el siguiente inventario para el articulo
      | Color | Talle | Stock | Sucursal |
      | Azul  | 38    | 3     | Centro   |
      | Rojo  | 38    | 2     | Centro   |
    When ingreso el codigo del articulo 1234
    Then se muestra los detalles del articulo
      | Codigo | Marca | Categoria | Precio   |
      | 1234   | Nike  | Zapatilla | 15000.00 |
    And su correspondiente inventario
      | Color | Talle | Stock | Sucursal |
      | Azul  | 38    | 3     | Centro   |
      | Rojo  | 38    | 2     | Centro   |

  Scenario: Buscar articulo que no tiene stock
    Given el siguiente articulo
      | Codigo | Marca | Categoria | Precio   |
      | 1234   | Nike  | Zapatilla | 15000.00 |
    And el siguiente inventario para el articulo
      | Color | Talle | Stock | Sucursal |
      | Azul  | 38    | 0     | Centro   |
      | Rojo  | 38    | 0     | Centro   |
    When ingreso el codigo del articulo 1234
    Then se muestra un mensaje indicando la faltante de stock del articulo ingresado

  Scenario: Buscar articulo inexistente
    Given el siguiente articulo
      | Codigo | Marca | Categoria | Precio   |
      | 1234   | Nike  | Zapatilla | 15000.00 |
    When ingreso un codigo inexistente del articulo 1235
    Then se muestra un mensaje indicando que el codigo ingresado no existe