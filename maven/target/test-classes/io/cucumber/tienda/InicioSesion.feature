Feature: Iniciar Sesion

Scenario: Inicio de sesión exitoso
    Given que existe un punto de venta con el número 1
    And un usuario con nombre de usuario "usuario1" y contraseña "contrasena123"
    When el usuario inicia sesión en el punto de venta
    Then el punto de venta debería tener una sesión activa
