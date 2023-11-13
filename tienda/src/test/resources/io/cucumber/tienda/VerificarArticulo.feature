Feature: Buscar articulo y agregarlo a venta.
  Como vendedor
  Quiero conocer la informacion de un articulo y agregarlo a una venta
  Para conocer lo que el cliente quiere comprar y el poder informar el total

  Scenario: Obtener detalles del artiuclo por codigo en una sucursal.
    Given una venta en proceso
    And un articulo con codigo 1234 con los siguientes datos:
      | Descripcion          | Marca | Categoria | Precio  |
      | Camisa Mangas Largas | Polo  | Camisas   | 1000.00 |
    And el inventario disponible para una combinacion de talles y colores para la sucursal "centro" es la siguiente:
      | Color | Talle | Stock |
      | Rojo  | M     | 10    |
      | Rojo  | S     | 15    |
    When ingreso el codigo del articulo 1234
    Then se obtiene la siguiente informacion del articulo:
      | Codigo | Descripcion          | Marca | Categoria | Precio  |
      | 1234   | Camisa Mangas Largas | Polo  | Camisas   | 1000.00 |
    And la siguiente informacion del stock:
      | Sucursal | Color | Talle | Stock |
      | Centro   | Rojo  | M     | 10    |
      | Centro   | Rojo  | S     | 15    |