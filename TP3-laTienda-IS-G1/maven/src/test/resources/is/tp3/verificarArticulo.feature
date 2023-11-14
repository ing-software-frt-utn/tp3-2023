Feature: Verificar Articulo
  Como    Vendedor
  Quiero  validar la existencia de un articulo
  Para    poder gestionarlo

  Scenario: Articulo Existente
    Given existen los siguientes articulos:
      | Codigo | Marca | Descripcion | Precio |
      |  123   | Pumba | Remerita    | 1200   |
    When ingreso el codigo 123
    Then se muestra la siguiente informacion del articulo:
      | Codigo | Marca | Descripcion | Precio |
      |  123   | Pumba | Remerita    | 1200   |