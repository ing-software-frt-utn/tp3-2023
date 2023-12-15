Feature: buscar producto
    Scenario: Buscar producto existente
        Given existen los siguientes productos:
        | código | talle | color   | stock |
        | 001    | M     | naranja | 5     |
        | 001    | L     | azul    | 10    |
        | 003    | M     | naranja | 0     |
        | 004    | XS    | rojo    | 5     |
        | 004    | XL    | morado  | 0     |
        When se ingresa el código "001"
        Then el sistema muestra:
        | código | talle | color   | stock |
        | 001    | M     | naranja | 5     |
        | 001    | L     | azul    | 10    |
   
    Scenario: Buscar producto inexistente
        Given existen los siguientes productos:
        | código | talle | color   | stock |
        | 001    | M     | naranja | 5     |
        | 001    | L     | azul    | 10    |
        | 003    | M     | naranja | 0     |
        | 004    | XS    | rojo    | 5     |
        | 004    | XL    | morado  | 0     |
        When se ingresa el código "002"
        Then el sistema muestra un mensaje: "Producto no encontrado"

    Scenario: Buscar producto sin stock
        Given existen los siguientes productos:
        | código | talle | color   | stock |
        | 001    | M     | naranja | 5     |
        | 001    | L     | azul    | 10    |
        | 003    | M     | naranja | 0     |
        | 004    | XS    | rojo    | 5     |
        | 004    | XL    | morado  | 0     |
        When se ingresa el código "003"
        Then el sistema muestra un mensaje: "Producto sin stock"

