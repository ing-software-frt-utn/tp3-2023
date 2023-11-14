Feature: Borrar Articulo

    Como administrador
    Quiero borrar articulos
    Para deshabilitar la disponibilidad de los articulos no existentes
       
    Scenario: Baja logica de articulo existente
        Given existe un articulo 123 sin inventarios asociados
        Given se listo la informacion del articulo 123
        When elimino el articulo 123
        Then el articulo 123 sufre un borrado logico