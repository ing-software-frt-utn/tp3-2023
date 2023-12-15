Feature: Agregar Cliente
  Como vendedor
  Quiero ingresar un cliente
  Para asociarlo a la venta en curso

Scenario: asociar a la venta un cliente nuevo
Given una venta:
  |numero|  fecha   | total |
  |1     |15/02/2023| 18150.0  |
When ingreso el dni del cliente 123456891 inexistente
Then completo los siguientes datos del formulario:
  | Nombre y Apellido | Condicion Tributaria | Razon Social| CUIT           | DNI      | Domicilio       | Localidad |
  | Fernando Alonso   |      RI              |   FA group  | 301234568912 | 123456891| Santiago 1600   | Capital   |
And se asocia el cliente a la venta
