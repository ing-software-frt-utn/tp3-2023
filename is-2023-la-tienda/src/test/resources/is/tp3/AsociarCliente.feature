#noinspection SpellCheckingInspection
Feature: Asociacion de Cliente
  Como    Vendedor
  Quiero  Registrar un cliente
  Para    Asociarlo a la venta

  Background:
    Given existen los siguientes clientes registrados:
      | DNI      | Condicion Tributaria | CUIL / CUIT   | Nombre / Razon Social | Domicilio | Localidad     |
      | 0        | CF                   | 00-00000000-0 | Anonimo               | Anonimo   | SM de Tucuman |
      | 12345678 | RI                   | 20-12345678-8 | Juan Perez            | XXA       | SM de Tucuman |

 # Prueba 1
  Scenario: Asociar un cliente a la venta
    Given una venta en curso con la siguiente informacion:
      | Cliente Asociado |
      |     00000000     |
    When ingreso el DNI del cliente 12345678
    Then se asocia el cliente a la venta.
      | Cliente Asociado |
      |     12345678     |


 # Prueba 2
  Scenario: El cliente no existe
    When ingreso el DNI del cliente 11111111
    Then se muestra el siguiente mensaje "Cliente inexistente"


 # Prueba 3
  Scenario: Creación de Cliente Completando el Formulario
    When completo el formulario de creacion de cliente con los siguientes datos:
      | DNI   | Condicion Tributaria | CUIL / CUIT | Nombre / Razon Social | Domicilio | Localidad     |
      | 13579 | CF                   | 00-13579-0  | Juan Perez 2          | XXB         | SM de Tucuman |
    Then se registra al nuevo cliente
      | DNI      | Condicion Tributaria | CUIL / CUIT   | Nombre / Razon Social | Domicilio | Localidad     |
      | 0        | CF                   | 00-00000000-0 | Anonimo               | Anonimo   | SM de Tucuman |
      | 12345678 | RI                   | 20-12345678-8 | Juan Perez            | XXA       | SM de Tucuman |
      | 13579    | CF                   | 00-13579-0    | Juan Perez 2          | XXB       | SM de Tucuman |