Feature: Borrar Articulo

    Como administrador
    Quiero borrar articulos
    Para deshabilitar la disponibilidad de los articulos no existentes


    Scenario: Listar la informacion del articulo
        Given existe un articulo con el codigo 123, con la informacion
            | Codigo | Marca   | Descripcion    |
            | 123    | Lacoste | Remera fachera |
        When ingreso el codigo del articulo 123
        Then se muestra la informacion del articulo
            | Codigo | Marca   | Descripcion    |
            | 123    | Lacoste | Remera fachera |

       
    Scenario: Baja logica de articulo existente
        Given existe un articulo 123 sin inventarios asociados
        Given se listo la informacion del articulo 123
        When elimino el articulo 123
        Then el articulo 123 sufre un borrado logico


    #Scenario: Baja Logica de Articulo con inventario asociado
    #    Given existe un articulo 123 con los inventarios
    #        | Codigo | Talle | Color | Stock |
    #        | 123    | 32    | negro | 12    |
    #    When elimino el articulo 123
    #    Then se informa error al eliminar el articulo
    #    And el sistema muestra los inventarios asociados
    #        | Codigo | Talle | Color | Stock |
    #        | 123    | 32    | negro | 12    |