Feature: Agregar articulo a la venta

    Como vendedor
    Quiero agregar articulos a la venta
    Para reflejar la seleccion del cliente y conocer el total


    Scenario: Listar combinaciones de talle y stock e informacion de articulo existente
        Given una venta en proceso
        And existe un articulo con el codigo 123, con la informacion:
            | Codigo | Marca   | Descripcion    |
            | 123    | Lacoste | Remera fachera |
        And existen las siguientes combinaciones de talle y color para el articulo 123:
            | Talle | Color  | Stock |
            | 32    | negro  | 5     |
            | 36    | blanco | 4     |
            | 38    | rosa   | 0     |
        When ingreso el codigo 123
        Then se debe mostrar la siguiente informacion del articulo:
            | Marca   | Descripcion    |
            | Lacoste | Remera fachera |
        And Se deben listar las siguientes combinaciones de talle y color con stock mayor a 0:
            | Talle | Color  | Stock |
            | 32    | negro  | 5     |
            | 36    | blanco | 4     |