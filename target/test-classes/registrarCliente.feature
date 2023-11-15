Feature: Registrar nuevo cliente

  Scenario: Registrar Cliente Exitosamente.
    Given que exista un cliente con dni "33665566", nombre "Juan" y domicilio "SMT" que quiere ser dado de alta y no este registrado
    When se inicializa el registro del cliente con dni "33665566", nombre "Juan" y domicilio "SMT"
    Then el sistema Registra un nuevo cliente con dni "33665566", nombre "Juan" y domicilio "SMT"
    And El sistema muestra un mensaje de "Registro Exitoso"
