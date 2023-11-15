  Feature: Buscar artículo y agregarlo
  Como vendedor
  Quiero conocer la información y agregarlo a una venta
  Para conocer lo que el cliente quiere comprar y el poder informar el total

    Scenario: Obtener detalles del articulo por codigo en una sucursal
      Given una venta en proceso
      And un articulo con código 1234 con los siguientes datos:
      | Descripcion         | Marca   | Categoria |   Precio |
      | Camisa Mangas Largas| Polo    | Camisas   |   1000.00|
      And el inventario disponible para una combinación de talles y colores para la sucursal "Centro" es la siguiente:
      |Color|Talle|Cantidad|
      |Rojo |M    | 10     |
      |Rojo |S    | 15     |
      When ingreso el código de artículo 1234
      Then se obtiene la siguiente información del artículo:
      |Codigo       |Descripcion         |Marca|Categoria|Precio |
      |1234         |Camisa Mnagas largas|Polo |Camisas  |1000.00|
      And la siguiente información del stock:
      |Sucursal     |Color               |Talle |Stock   |
      |Centro       |Rojo                |M     |10      |
      |Centro       |Rojo                |S     |15      |
