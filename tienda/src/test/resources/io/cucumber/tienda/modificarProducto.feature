Feature: Modificación de un producto

  Como administrador
  Quiero modificar los datos de un producto
  Para que refleje la realidad actual del producto

  Scenario: Modificación correcta
    Given existe un producto con los siguientes datos:
      | Id   | Descripción    | Marca         | Categoría      |
      | 1234 | Pantalón largo | 1 (Taverniti) | 1 (Pantalones) |
    When solicito cambiar la descripción del producto "1234" a "Pantalón de Jean"
    Then se cambian los datos del producto por:
      | Id   | Descripción      | Marca         | Categoría      |
      | 1234 | Pantalón de Jean | 1 (Taverniti) | 1 (Pantalones) |
