Feature: Agregar Artículo
    Como vendedor, quiero agregar artículos para cargar en un listado de artículos de la venta en curso.

    Scenario: Se agrega el artículo al listado
        Given una venta en curso
        When selecciono un artículo "<Articulo>" por su talle "<Talle>" color "<Color>", precio "<Precio>", stock "<Stock>", en sucursal "<Sucursal>" de la lista de artículos encontrados
        And se ingresa la cantidad de artículos necesarios "<Cantidad>"
        Then se agrega el artículo a la lista de artículos de la venta
            | Articulo | Talle | Color | Precio | Stock | Cantidad | Sucursal |
            | Remera   | L     | Roja  | $8000  | 20    | 2        | Centro   |

    Scenario: Selección de artículo sin stock
        Given una venta en curso
        When selecciono un artículo "<Articulo>" por su talle "<Talle>" color "<Color>", precio "<Precio>", stock "0", en sucursal "<Sucursal>" de la lista de artículos encontrados
        Then se indica que el artículo no posee existencias en su inventario
            | Articulo | Talle | Color | Precio | Stock | Cantidad | Sucursal |
            | Remera   | L     | Roja  | $8000  | 0     | 2        | Centro   |

    Scenario: Selección de cantidad de artículo insuficiente
        Given una venta en curso
        When selecciono un artículo "<Articulo>" por su talle "<Talle>" color "<Color>", precio "<Precio>", stock "2", en sucursal "<Sucursal>" de la lista de artículos encontrados
        And se ingresa la cantidad de artículos necesarios "3"
        Then se indica que el artículo no posee stock suficiente en su inventario
            | Articulo | Talle | Color | Precio | Stock | Cantidad | Sucursal |
            | Remera   | L     | Roja  | $8000  | 2     | 3        | Centro   |