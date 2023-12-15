Feature: Pago en Efectivo
Como vendedor 
Quiero registrar un pago en efectivo 
Para concretar una venta 

Scenario: cambio de tipo de pago a efectivo
Given una venta con los datos:
  |numero|  fecha   | total   | dniCliente |
  |1     |15/02/2023| 18150.0 | 43501538   |
When selecciono pagar en efectivo
Then se actualiza el tipo de pago a efectivo


