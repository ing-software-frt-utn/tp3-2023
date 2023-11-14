Feature: Listar Articulo
  Como vendedor
  Quiero agregar articulos a la venta
  Para reflejar la selección del cliente


Scenario: Listar combinaciones de articulos existentes
  Given una venta en proceso
  And existen los siguientes articulos en stock:
      | Codigo | Marca | Descripcion | Precio |
      | 123    |Adidas | Remera Over | 20000  |
      | 124    |Nike   | Remera Over | 25000  |
    And existen las siguientes combinaciones de talle y color:
      | Codigo | Talle | Color  |Cantidad|
      | 123    | S     | negro  | 2      |
      | 123    | M     | blanco | 4      |
      | 124    | M     | rosa   | 3      |

  When se ingresa el codigo 123

  Then muestra la siguiente informacion del articulo:
      | Codigo | Marca  | Descripcion | Precio |
      | 123    | Adidas | Remera Over | 20000  |
  And se muestra la siguiente informacion del articulo solicitado:
      | Codigo  | Talle | Color | Cantidad |
      | 123     | S     | negro | 2        |
      | 123     | M     | blanco| 4        |
