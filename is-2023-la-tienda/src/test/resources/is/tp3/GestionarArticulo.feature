#noinspection SpellCheckingInspection
Feature: Verificar Articulo
 Como    Vendedor
 Quiero  validar la existencia de un articulo
 Para    poder gestionarlo

  Background:
    Given existen los siguientes articulos:
      | Codigo | Marca | Descripcion | Precio |
      |  123   | Pumba | Remerita    | 1200   |

 # Prueba 1
  Scenario: Articulo Inexistente
    When ingreso el codigo 321
    Then se muestra el mensaje siguiente "Articulo Inexistente"

 # Prueba 2
  Scenario: Articulo Existente
    When ingreso el codigo 123
    Then se muestra la siguiente informacion del articulo:
      | Codigo | Marca | Descripcion | Precio |
      |  123   | Pumba | Remerita    | 1200   |
