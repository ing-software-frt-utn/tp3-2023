Feature: Inicio de Sesión

  Scenario: Inicio de sesión correcto
    Given un punto de venta válido sin sesión iniciada
    And un usuario con los siguientes datos:
      | Usuario       | Contraseña |
      | juliocalisaya | 123456     |
    When solicito iniciar sesión con usuario "juliocalisaya" y contraseña "123456"
    Then se inicia correctamente la sesión en el punto de venta
