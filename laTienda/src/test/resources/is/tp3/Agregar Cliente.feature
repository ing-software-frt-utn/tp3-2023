Feature: Agregar Cliente
  Como vendedor
  Quiero ingresar un cliente
  Para asociarlo a la venta en curso

Scenario: cliente cargado correctamente
Given una venta:
  |numero|  fecha   |     estado      |
  |1     |15/02/2023|Pendiente de pago|
And no existe un cliente asociado a la venta 
When completo los siguientes datos del formulario:
| Nombre y Apellido | Condicion Tributaria | Razon Social| CUIT           | DNI      | Domicilio       | Localidad |
| Fernando Alonso   |      RI              |   FA group  | 301234568912 | 123456891| Santiago 1600   | Capital   |
Then se asocia el cliente a la venta
